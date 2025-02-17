eval $(minikube docker-env)
cd backend
docker build -t my-fastapi:v1 .
cd ..

