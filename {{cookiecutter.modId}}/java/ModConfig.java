package {{ cookiecutter.modGroup }}.config;

import blue.endless.jankson.Comment;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.NotNull;
import top.offsetmonkey538.offsetconfig538.api.config.Config;

import java.nio.file.Path;

import static {{ cookiecutter.modGroup }}.{{ cookiecutter.modMainClass }}.MOD_ID;

public class ModConfig implements Config {

    @Comment("This is an example config entry.")
    public String coolValue = "Hello, World!";

    @Override
    public @NotNull Path getFilePath() {
        return FabricLoader.getInstance().getConfigDir().resolve(getId());
    }

    @Override
    public @NotNull String getId() {
        return "%s/main.json".formatted(MOD_ID);
    }
}
