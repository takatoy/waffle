package wafflecore.model;

import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {
    @JsonIgnore
    private byte[] original;
    @JsonProperty("id")
    private byte[] id;
    @JsonProperty("timestamp")
    private long timestamp;
    @JsonProperty("in")
    private ArrayList<InEntry> inEntries;
    @JsonProperty("out")
    private ArrayList<OutEntry> outEntries;
    @JsonIgnore
    private TransactionExecInfo execInfo;

    public Transaction() {
        this.original = null;
        this.id = null;
        this.timestamp = 0;
        this.inEntries = null;
        this.outEntries = null;
        this.execInfo = null;
    }

    public Transaction(
        byte[] original,
        byte[] id,
        long timestamp,
        ArrayList<InEntry> inEntries,
        ArrayList<OutEntry> outEntries,
        TransactionExecInfo execInfo)
    {
        this.original = original;
        this.id = id;
        this.timestamp = timestamp;
        this.inEntries = inEntries;
        this.outEntries = outEntries;
        this.execInfo = execInfo;
    }

    public String toJson() {
        String json = "";
        ObjectMapper mapper = new ObjectMapper();

        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.err.println("Invalid transaction data detected.");
            e.printStackTrace();
        }

        return json;
    }

    // getter
    public byte[] getOriginal() {
        return original;
    }
    public byte[] getId() {
        return id;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public ArrayList<InEntry> getInEntries() {
        return inEntries;
    }
    public ArrayList<OutEntry> getOutEntries() {
        return outEntries;
    }
    public TransactionExecInfo getExecInfo() {
        return execInfo;
    }

    // setter
    public void setOriginal(byte[] original) {
        this.original = original;
    }
    public void setId(byte[] id) {
        this.id = id;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public void setInEntries(ArrayList<InEntry> inEntries) {
        this.inEntries = inEntries;
    }
    public void setOutEntries(ArrayList<OutEntry> outEntries) {
        this.outEntries = outEntries;
    }
    public void setExecInfo(TransactionExecInfo execInfo) {
        this.execInfo = execInfo;
    }
}
