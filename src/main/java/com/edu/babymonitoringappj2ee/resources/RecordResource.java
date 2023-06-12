package com.edu.babymonitoringappj2ee.resources;

import com.edu.babymonitoringappj2ee.dto.RecordDto;
import com.edu.babymonitoringappj2ee.service.RecordService;
import jakarta.ws.rs.*;

@Path("/record")
public class RecordResource {
    private RecordService recordService;


    @GET
    @Path("/ping")
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("/get/{id}")
    public RecordDto getRecord(@PathParam("id") int accountId) {
        return recordService.readRecordByAccountId(accountId);
    }

    @POST
    @Path("/create")
    public RecordDto createRecord(RecordDto recordDto) {
        return recordService.saveRecord(recordDto);
    }
}
