package com.ge.predix.solsvc.iothydrator.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author predix -
 */
@Consumes(
{
        "application/json", "application/xml"
})
@Produces(
{
        "application/json", "application/xml"
})
@Path("/iothydrator")
@Api(value = "/iothydrator")
public interface IoTHydratorAPI
{
    /**
     * @return -
     */
    @GET
    @Path("/ping")
    @ApiOperation(value = "/ping")
    public Response greetings();


    /**
     * @param id
     *            -
     * @param authorization
     *            -
     * @param starttime
     *            -
     * @param tagLimit -
     * @param tagorder -
     * @return -
     */
    @GET
    @Path("/yearly_data/sensor_id/{id}")
    @ApiOperation(value = "/yearly_data/sensor_id/{id}")
    public Response getYearlyIoTHydratorDataPoints(@PathParam("id") String id,
                                                   @HeaderParam(value = "Authorization") String authorization,
                                                   @DefaultValue("1y-ago") @QueryParam("starttime") String starttime,
                                                   @DefaultValue("25") @QueryParam("taglimit") String tagLimit,
                                                   @DefaultValue("desc") @QueryParam("order") String tagorder);

    /**
     * @param id
     *            -
     * @param authorization
     *            -
     * @return -
     */
    @GET
    @Path("/latest_data/sensor_id/{id}")
    @ApiOperation(value = "/latest_data/sensor_id/{id}")
    public Response getLatestIotHydratorDataPoints(@PathParam("id") String id,
                                                   @HeaderParam(value = "authorization") String authorization);

    /**
     * 
     * @param authorization -
     * @return List of tags
     */
    @GET
    @Path("/tags")
    @ApiOperation(value ="/tags")
    public Response getIoTHydratorTags(@HeaderParam(value = "authorization") String authorization);

    /**
     *
     * @param measure the value of the datapoint
     * @param quality the quality of the datapoint
     * @param name the name of the body entry we are submitting, this shit must be json
     * @return add a datapoint
     */
    @GET
    @Path("/add_datapoint/{measure}/{quality}/{name}/{attributes}")
    @ApiOperation(value ="/add_datapoint/{measure}/{quality}/{name}/{attributes}")
    public Response addDatapoint(@PathParam("measure") String measure, @PathParam("quality") String quality, @PathParam("name") String name, @PathParam("attributes") String attributes);

    /**
     *
     */
    @GET
    @Path("/test")
    @ApiOperation(value ="/test")
    public Response test();

}
