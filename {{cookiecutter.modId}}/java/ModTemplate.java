package {{ cookiecutter.modGroup }};

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
{%- if cookiecutter.includeBlockRegistryClass == "yes" %}

import {{ cookiecutter.modGroup }}.block.ModBlocks;
{%- endif %}
{%- if cookiecutter.includeItemRegistryClass == "yes" %}

import {{ cookiecutter.modGroup }}.item.ModItems;
{%- endif %}
{%- if cookiecutter.includeConfigLibrary == "yes" %}

import {{ cookiecutter.modGroup }}.config.ModConfig;
import top.offsetmonkey538.monkeyconfig538.ConfigManager;
{%- endif %}

public class {{ cookiecutter.modMainClass }} implements ModInitializer {
	public static final String MOD_ID = "{{ cookiecutter.modId }}";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Do stuff
		{%- if cookiecutter.includeConfigLibrary == "yes" %}
		ConfigManager.init(new ModConfig(), MOD_ID);
		{%- endif %}
		{%- if cookiecutter.includeBlockRegistryClass == "yes" %}
		ModBlocks.register();
		{%- endif %}
		{%- if cookiecutter.includeItemRegistryClass == "yes" %}
		ModItems.register();
		{%- endif %}
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
	{%- if cookiecutter.includeConfigLibrary == "yes" %}

	public static ModConfig config() {
		return (ModConfig) ConfigManager.get(MOD_ID);
	}
	{%- endif %}
}
