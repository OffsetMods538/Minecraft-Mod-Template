package {{ cookiecutter.modGroup }}.config;

import top.offsetmonkey538.monkeyconfig538.Config;
import top.offsetmonkey538.monkeyconfig538.annotation.ConfigEntry;

public class ModConfig extends Config {

    /*
     Example usage:
     @ConfigEntry("I have a comment!")
     public static int coolValue = 123;
     */

    @Override
    protected String getName() {
        return "{{ cookiecutter.modId }}";
    }
}
