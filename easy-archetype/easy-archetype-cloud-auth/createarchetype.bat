echo "生成脚手架项目"


mvn archetype:create-from-project && cd target/generated-sources/archetype && mvn install