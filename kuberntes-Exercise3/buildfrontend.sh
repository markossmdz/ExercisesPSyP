eval $(minikube docker-env)
cd frontend
docker build -t my-frontend:latest .
cd ..

