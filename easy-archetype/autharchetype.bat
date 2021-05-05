echo "create auth project archetype"
echo "step 1 create common archetype"
set dir=%~dp0
cd easy-archetype-common
mvn archetype:create-from-project && cd target/generated-sources/archetype && mvn install && cd  %dir%  && cd easy-archetype-system &&mvn archetype:create-from-project && cd target/generated-sources/archetype && mvn install & cd  %dir%  && cd easy-archetype-cloud-auth &&mvn archetype:create-from-project && cd target/generated-sources/archetype && mvn install & cd  %dir%




