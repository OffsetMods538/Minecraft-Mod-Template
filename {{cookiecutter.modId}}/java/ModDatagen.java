package {{ cookiecutter.modGroup }}.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class {{ cookiecutter.modMainClass }}Datagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        final FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        /*
        Example:
        pack.addProvider(MyEnglishLanguageProvider::new)
         */
    }
}
