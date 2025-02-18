
# Building a Multi-Service Application with In-Place Upgrades on Kubernetes


## Prerequisites
You will need to have installed:

- Install **Minikube**: [Minikube Start Guide](https://minikube.sigs.k8s.io/docs/start/)
- Install **kubectl**
- Install **Docker**

---

## Deployment Steps

### 1. Set Up Kubernetes Environment
```sh
minikube start
```

## 2. Create and Containerize Your Services

#### Backend API (FastAPI)

- Download API code (backend/app.py)

- Define dependencies (backend/requirements.txt)

- Write the Dockerfile (backend/Dockerfile)

- Build the backend image:

```sh
eval $(minikube docker-env)
docker build -t backend:v1 ./backend
```

#### Frontend (Node.js)

- Download frontend code (frontend/server.js)

- Define dependencies (frontend/package.json)

- Write the Dockerfile (frontend/Dockerfile)

- Build the frontend image:

```sh
docker build -t frontend:v1 ./frontend
```

## 3. Deploy Services to Kubernetes

#### Download Kubernetes Deployment YAMLs:

- Backend Deployment (backend-deployment.yaml)

- Frontend Deployment (frontend-deployment.yaml)

#### Download Kubernetes Services:

- Backend Service (backend-service.yaml)

- Frontend Service (frontend-service.yaml)

#### Deploy Everything

```sh
kubectl apply -f backend-deployment.yaml
kubectl apply -f backend-service.yaml
kubectl apply -f frontend-deployment.yaml
kubectl apply -f frontend-service.yaml
```

#### Access the Application

Test the Application

```sh
minikube service frontend-service
```

Open the displayed URL to see the frontend.

## 4. Demonstrating In-Place Upgrades (Rolling Update)

Edit backend/app.py so that the API returns a different message (for example, indicating
version 2)

#### Build the new backend image:

```sh
docker build -t backend:v2 ./backend
```

#### Perform a rolling update in Kubernetes:
```sh
kubectl set image deployment/backend-deployment backend=backend:v2
```

#### Monitor the rolling update:

```sh
kubectl rollout status deployment/backend-deployment
```

Then verify the update by refreshing the frontend page.

#### Rollback (Optional)

```sh
kubectl rollout undo deployment/backend-deployment
```

Verify the rollback success by refreshing the page again.
