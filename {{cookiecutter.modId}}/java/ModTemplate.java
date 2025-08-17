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
{%- if cookiecutter.includeConfigClass == "yes" %}

import {{ cookiecutter.modGroup }}.config.ModConfig;
import top.offsetmonkey538.offsetconfig538.api.config.ConfigHolder;
import top.offsetmonkey538.offsetconfig538.api.config.ConfigManager;
{%- endif %}

public class {{ cookiecutter.modMainClass }} implements ModInitializer {
	public static final String MOD_ID = "{{ cookiecutter.modId }}";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	{%- if cookiecutter.includeConfigClass == "yes" %}

	public static final ConfigHolder<ModConfig> config = ConfigManager.init(ConfigHolder.create(ModConfig::new, LOGGER::error));
	{%- endif %}

	@Override
	public void onInitialize() {
		{%- if cookiecutter.includeBlockRegistryClass == "yes" %}
		ModBlocks.register();
		{%- endif %}
		{%- if cookiecutter.includeItemRegistryClass == "yes" %}
		ModItems.register();
		{%- endif %}
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
