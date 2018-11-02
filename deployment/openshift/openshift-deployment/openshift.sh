oc login -u=ihg-demouser -p=ihg-demopasswd --server=https://master.openshiftcognizant.com:8443 --insecure-skip-tls-verify
oc project propertymgmt
oc new-app propertymgmt/config-server:latest --name=config-server
oc new-app propertymgmt/hotel-details-service:latest --name=hotel-details-service
oc new-app propertymgmt/inventory-service:latest --name=inventory-service
oc new-app propertymgmt/price-service:latest --name=price-service
oc new-app propertymgmt/property-search-service:latest --name=property-search-service

oc expose svc/config-server
oc expose svc/hotel-details-service
oc expose svc/inventory-service
oc expose svc/price-service
oc expose svc/property-search-service
