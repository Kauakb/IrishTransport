import csv
import pymongo

# Connect to MongoDB Atlas
client = pymongo.MongoClient("mongodb+srv://Kaua200202:ALs9hiUXUTc2gPpx@cluster0.qezqfwt.mongodb.net/transortdb?retryWrites=true&w=majority")

db = client["transortdb"]
collection = db["transports"]

# Clear existing data
collection.delete_many({})

# Import CSV
with open("NaPTAN_Stop_Points.csv", encoding="utf-8") as f:
    reader = csv.DictReader(f)
    documents = []
    for row in reader:
        doc = {
            "atcoCode": row.get("AtcoCode", ""),
            "commonName": row.get("CommonName", ""),
            "street": row.get("Street", ""),
            "locality": row.get("NptgLocalityRef", ""),
            "latitude": float(row["Latitude"]) if row.get("Latitude") else None,
            "longitude": float(row["Longitude"]) if row.get("Longitude") else None,
            "stopType": row.get("StopType", ""),
            "busStopType": row.get("BusStopType", ""),
            "status": row.get("Status", ""),
            "timingStatus": row.get("TimingStatus", "")
        }
        documents.append(doc)

    collection.insert_many(documents)
    print(f"Imported {len(documents)} documents!")

client.close()