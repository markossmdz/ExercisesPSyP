from fastapi import FastAPI # type: ignore
import os

app = FastAPI()

@app.get("/")
def read_root():
    return{"message": "Hello from FastAPI v2 - Upgraded!"}

@app.get("/status")
def status():
    return {"status": "API Running", "host": os.getenv("HOSTNAME")}