import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.object.command.CommandResponse;
import discord4j.core.spec.EmbedCreateSpec;
import reactor.core.publisher.Mono;

public class SlashCommandHandler {
    private final QrCodeEncoder qrCodeEncoder;
    private final QrData qrData;

    public SlashCommandHandler(QrCodeEncoder qrCodeEncoder, QrData qrData) {
        this.qrCodeEncoder = qrCodeEncoder;
        this.qrData = qrData;
    }

    public Mono<Void> handle(ChatInputInteractionEvent event) {
        var command = event.getCommandName();
        var response = switch (command) {
            case "qr" -> handleQrCommand(event);
            case "qrsave" -> handleQrSaveCommand(event);
            case "qrload" -> handleQrLoadCommand(event);
            default -> Mono.just(CommandResponse.notFound());
        };

        return event.reply(response);
    }

    private Mono<CommandResponse> handleQrCommand(ChatInputInteractionEvent event) {
        var textOption = event.getOption("text");
        if (textOption.isEmpty()) {
            return Mono.just(CommandResponse.invalidRequest("Missing 'text' option."));
        }

        var text = textOption.get().getValue().getAsString();
        var imageBytes = qrCodeEncoder.encode(text);

        return event.reply(spec -> spec.addFile("qr.png", imageBytes));
    }

    private Mono<CommandResponse> handleQrSaveCommand(ChatInputInteractionEvent event) {
        var textOption = event.getOption("text");
        var nameOption = event.getOption("name");
        if (textOption.isEmpty() || nameOption.isEmpty()) {
            return Mono.just(CommandResponse.invalidRequest("Missing 'text' or 'name' option."));
        }

        var text = textOption.get().getValue().getAsString();
        var name = nameOption.get().getValue().getAsString();
        qrData.saveQr(name, text);

        return event.reply(spec -> {
            spec.setContent("QR code saved successfully!");
            spec.addEmbed(createEmbedForQr(name, text));
        });
    }

    private Mono<CommandResponse> handleQrLoadCommand(ChatInputInteractionEvent event) {
        var nameOption = event.getOption("name");
        if (nameOption.isEmpty()) {
            return Mono.just(CommandResponse.invalidRequest("Missing 'name' option."));
        }

        var name = nameOption.get().getValue().getAsString();
        var text = qrData.loadQr(name);
        if (text.isEmpty()) {
            return Mono.just(CommandResponse.invalidRequest("QR code with the specified name not found."));
        }

        var imageBytes = qrCodeEncoder.encode(text);

        return event.reply(spec -> {
            spec.setContent("QR code loaded successfully!");
            spec.addFile("qr.png", imageBytes);
            spec.addEmbed(createEmbedForQr(name, text));
        });
    }

    private EmbedCreateSpec createEmbedForQr(String name, String text) {
        return spec -> {
            spec.setTitle("QR Code: " + name);
            spec.setDescription("Encoded Text: " + text);
        };
    }
}
