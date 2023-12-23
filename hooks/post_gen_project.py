import os
import shutil

directory = "{{ cookiecutter.modGroup.replace('.', '/') }}"

javaDir = "src/main/java/" + directory
clientJavaDir = "src/client/java/" + directory

resourcesDir = "src/main/resources"
clientResourcesDir = "src/client/resources"

assetsDir = resourcesDir + "/assets/{{ cookiecutter.modId }}"


os.makedirs(javaDir, exist_ok=True)
os.makedirs(clientJavaDir, exist_ok=True)

os.makedirs(javaDir + "/mixin", exist_ok=True)
os.makedirs(clientJavaDir + "/mixin/client", exist_ok=True)

os.makedirs(resourcesDir, exist_ok=True)
os.makedirs(clientResourcesDir, exist_ok=True)

os.makedirs(assetsDir, exist_ok=True)

os.makedirs("run/server", exist_ok=True)


if "{{ cookiecutter.includeBlockRegistryClass }}" == "yes":
    os.makedirs(javaDir + "/block", exist_ok=True)
    os.rename("java/ModBlocks.java", javaDir + "/block/ModBlocks.java")

if "{{ cookiecutter.includeItemRegistryClass }}" == "yes":
    os.makedirs(javaDir + "/item", exist_ok=True)
    os.rename("java/ModItems.java", javaDir + "/item/ModItems.java")

if "{{ cookiecutter.includeConfigLibrary }}" == "yes":
    os.makedirs(javaDir + "/config", exist_ok=True)
    os.rename("java/ModConfig.java", javaDir + "/config/ModConfig.java")

if "{{ cookiecutter.includeDataGeneration }}" == "yes":
    os.makedirs("src/main/generated", exist_ok=True)
    os.makedirs(javaDir + "/datagen", exist_ok=True)
    os.rename("java/ModDatagen.java", javaDir + "/datagen/{{ cookiecutter.modMainClass }}Datagen.java")


os.rename("java/ModTemplate.java", javaDir + "/{{ cookiecutter.modMainClass }}.java")
os.rename("java/ModTemplateClient.java", clientJavaDir + "/{{ cookiecutter.modMainClass }}Client.java")

os.rename("resources/icon.png", assetsDir + "/icon.png")
os.rename("resources/fabric.mod.json", resourcesDir + "/fabric.mod.json")
os.rename("resources/mod-template.accesswidener", resourcesDir + "/{{ cookiecutter.modId }}.accesswidener")
os.rename("resources/mod-template.mixins.json", resourcesDir + "/{{ cookiecutter.modId }}.mixins.json")

os.rename("resources/mod-template.client.mixins.json", clientResourcesDir + "/{{ cookiecutter.modId }}.client.mixins.json")

shutil.rmtree("java")
shutil.rmtree("resources")


os.system("gradle wrapper --gradle-version=8.5 --gradle-distribution-sha256-sum=9d926787066a081739e8200858338b4a69e837c3a821a33aca9db09dd4a41026")
os.system("gradle outletPropertiesUpdate")
os.system("gradle genSourcesWithFernFlower")


if "{{ cookiecutter.initGit }}" == "yes":
    os.system("git init")
    os.system("git add --all")
    os.system("git commit -m \"Initial Commit\"")
    os.system("git branch -M master")
    os.system("git remote add origin {{ cookiecutter.modSources }}.git")
