from fastapi import FastAPI
import os

app = FastAPI()

@app.get("/")
def read_root():
    return{"message": "Hello from FastAPI v1 on Kubernetes"}

@app.get("/status")
def status():
    return {"status": "API Running", "host": os.getenv("HOSTNAME")}