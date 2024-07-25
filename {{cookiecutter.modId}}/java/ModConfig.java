package {{ cookiecutter.modGroup }}.config;

import blue.endless.jankson.Comment;
import top.offsetmonkey538.monkeylib538.config.Config;

import static {{ cookiecutter.modGroup }}.{{ cookiecutter.modMainClass }}.MOD_ID;

public class ModConfig extends Config {

    @Comment("This is an example config entry.")
    public String coolValue = "Hello, World!";

    @Override
    protected String getName() {
        return MOD_ID;
    }
}
