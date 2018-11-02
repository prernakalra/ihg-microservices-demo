oc login -u=ihg-demouser -p=ihg-demopasswd --server=https://master.openshiftcognizant.com:8443 --insecure-skip-tls-verify

oc tag propertymgmt/config-server propertymgmt/config-server:latest
oc tag propertymgmt/hotel-details-service propertymgmt/hotel-details-service:latest
oc tag propertymgmt/inventory-service propertymgmt/inventory-service:latest
oc tag propertymgmt/price-service propertymgmt/price-service:latest
oc tag propertymgmt/property-search-service propertymgmt/property-search-service:latest


