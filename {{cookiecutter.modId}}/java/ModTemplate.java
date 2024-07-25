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
import top.offsetmonkey538.monkeylib538.config.ConfigManager;
{%- endif %}
{%- if cookiecutter.includeMonkeyLib538 == "yes" %}
import top.offsetmonkey538.monkeylib538.utils.IdentifierUtils;
{%- endif %}

public class {{ cookiecutter.modMainClass }} implements ModInitializer {
	public static final String MOD_ID = "{{ cookiecutter.modId }}";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	{%- if cookiecutter.includeConfigClass == "yes" %}

	public static ModConfig config;
	{%- endif %}

	@Override
	public void onInitialize() {
		{%- if cookiecutter.includeConfigClass == "yes" %}
		config = ConfigManager.init(new ModConfig(), LOGGER::error);
		ConfigManager.save(config, LOGGER::error);
		{%- endif %}
		{%- if cookiecutter.includeBlockRegistryClass == "yes" %}
		ModBlocks.register();
		{%- endif %}
		{%- if cookiecutter.includeItemRegistryClass == "yes" %}
		ModItems.register();
		{%- endif %}
	}

	public static Identifier id(String path) {
		{%- if cookiecutter.includeMonkeyLib538 == "yes" %}
		return IdentifierUtils.INSTANCE.of(MOD_ID, path);
		{%- else %}
		return new Identifier(MOD_ID, path);
		{%- endif %}
	}
}
