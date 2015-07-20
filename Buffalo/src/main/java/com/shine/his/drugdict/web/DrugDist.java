package com.shine.his.drugdict.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by claude on 15-6-29.
 */
@Path("/drugDist")
public class DrugDist {
    protected static final Logger logger = LoggerFactory.getLogger(DrugDist.class);
    private String name = "Drug Dist";

    @Path("/name")
    @GET
    public String getName() {
        logger.debug("get name method+" + name);
        try {
            Integer.valueOf("sad");
        } catch (NumberFormatException e) {
            logger.error("format error", e);
        }
        System.out.println(logger == null);

        return name;
    }
}
