package {{ cookiecutter.modGroup }};

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
{%- if cookiecutter.includeBlockRegistryClass == "yes" %}

import {{ cookiecutter.modGroup }}.block.ModBlocks;
{%- endif %}

public class {{ cookiecutter.modMainClass }} implements ModInitializer {
	public static final String MOD_ID = "{{ cookiecutter.modId }}";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Do stuff
		{%- if cookiecutter.includeBlockRegistryClass == "yes" %}
		ModBlocks.register();
		{%- endif %}
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
