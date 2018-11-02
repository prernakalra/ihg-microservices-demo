# login line
docker login -u ihg-demouser -p hQmhCdB-BHHrYE_85e_oPO8tXVBx1xJeHB1dmyYccac docker-registry-default.openshiftcognizant.com

cd ./config-server
pwd
docker build -t docker-registry-default.openshiftcognizant.com/propertymgmt/config-server:latest .
docker push  docker-registry-default.openshiftcognizant.com/propertymgmt/config-server:latest
docker rmi docker-registry-default.openshiftcognizant.com/propertymgmt/config-server:latest

cd ../hotel-details-service
docker build -t docker-registry-default.openshiftcognizant.com/propertymgmt/hotel-details-service:latest .
docker push  docker-registry-default.openshiftcognizant.com/propertymgmt/hotel-details-service:latest
docker rmi docker-registry-default.openshiftcognizant.com/propertymgmt/hotel-details-service:latest

cd ../inventory-service
docker build -t docker-registry-default.openshiftcognizant.com/propertymgmt/inventory-service:latest .
docker push  docker-registry-default.openshiftcognizant.com/propertymgmt/inventory-service:latest
docker rmi docker-registry-default.openshiftcognizant.com/propertymgmt/inventory-service:latest

cd ../price-service
docker build -t docker-registry-default.openshiftcognizant.com/propertymgmt/price-service:latest .
docker push  docker-registry-default.openshiftcognizant.com/propertymgmt/price-service:latest
docker rmi docker-registry-default.openshiftcognizant.com/propertymgmt/price-service:latest

cd ../property-search-service
docker build -t docker-registry-default.openshiftcognizant.com/propertymgmt/property-search-service:latest .
docker push  docker-registry-default.openshiftcognizant.com/propertymgmt/property-search-service:latest
docker rmi docker-registry-default.openshiftcognizant.com/propertymgmt/property-search-service:latest