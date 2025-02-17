mkk apply -f backend-deployment.yaml
mkk apply -f backend-service.yaml

mkk apply -f frontend-deployment.yaml
mkk apply -f frontend-service.yaml
