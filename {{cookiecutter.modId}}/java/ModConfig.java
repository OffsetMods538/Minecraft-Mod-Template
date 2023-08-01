package {{ cookiecutter.modGroup }}.config;

import blue.endless.jankson.Comment;
import top.offsetmonkey538.monkeyconfig538.Config;

public class ModConfig extends Config {

    @Comment("This is an example config entry.")
    public String coolValue = "Hello, World!";
}
