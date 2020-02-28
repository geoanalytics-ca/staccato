package com.planet.staccato.landsat8;

import com.planet.staccato.collection.CollectionMetadataAdapter;
import com.planet.staccato.extension.EO;
import com.planet.staccato.model.Provider;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author joshfix
 * Created on 10/23/18
 */
@Data
public class Landsat8CollectionMetadata extends CollectionMetadataAdapter<Landsat8ItemProperties> {

    public static final String ID = "landsat-8-l1";
    public static final String TITLE = "Landsat 8 L1";
    public static final String DESCRIPTION = "Landsat 8 imagery radiometrically calibrated and orthorectified using "
            + "ground points and Digital Elevation Model (DEM) data to correct relief displacement.";
    public static final String VERSION = "0.0.0";
    public static final String LICENSE = "PDDL-1.0";
    public static final String[] KEYWORDS = {"landsat", "landsat8"};
    public static final String CRS = "http://www.opengis.net/def/crs/OGC/1.3/CRS84";


    public Landsat8CollectionMetadata() {
        super();

        setId(ID);
        crs(CRS);
        setTitle(TITLE);
        setDescription(DESCRIPTION);
        setVersion(VERSION);
        setLicense(LICENSE);
        keywords.addAll(Arrays.asList(KEYWORDS));
        properties = new Landsat8ItemProperties();

        buildProperties();
        buildProviders();
    }

    private void buildProviders() {
        providers.add(Provider.build()
                .name("USGS")
                .addRole(Provider.Role.PRODUCER)
                .url("https://landsat.usgs.gov/"));
        /*
        providers.add(Provider.build()
                .name("Planet Labs")
                .addRole(Provider.Role.PROCESSOR)
                .url("https://github.com/landsat-pds/landsat_ingestor"));

        providers.add(Provider.build()
                .name("AWS")
                .addRole(Provider.Role.HOST)
                .url("https://landsatonaws.com/"));

        providers.add(Provider.build()
                .name("Planet Labs")
                .addRole(Provider.Role.PROCESSOR)
                .url("https://planet.com"));
         */
    }

    private void buildProperties() {
        properties.setPlatform("landsat-8");
        properties.setInstrument("OLI_TIRS");
        properties.setConstellation("landsat");
        properties.setOffNadir(0);
        properties.setBands(buildBands());
    }

    private List<EO.Band> buildBands() {
        List<EO.Band> bands = new ArrayList<>();
        bands.add(EO.Band.build()
                .name("B1")
                .commonName("coastal")
                .gsd(30)
                .centerWavelength(0.44d)
                .fullWidthHalfMax(0.02d)
        );

        bands.add(EO.Band.build()
                .name("B2")
                .commonName("blue")
                .gsd(30)
                .centerWavelength(0.48d)
                .fullWidthHalfMax(0.06d)
        );

        bands.add(EO.Band.build()
                .name("B3")
                .commonName("green")
                .gsd(30)
                .centerWavelength(0.56d)
                .fullWidthHalfMax(0.06d)
        );

        bands.add(EO.Band.build()
                .name("B4")
                .commonName("red")
                .gsd(30)
                .centerWavelength(0.65d)
                .fullWidthHalfMax(0.04d)
        );

        bands.add(EO.Band.build()
                .name("B5")
                .commonName("nir")
                .gsd(30)
                .centerWavelength(0.86d)
                .fullWidthHalfMax(0.03d)
        );

        bands.add(EO.Band.build()
                .name("B6")
                .commonName("swir16")
                .gsd(30)
                .centerWavelength(1.6d)
                .fullWidthHalfMax(0.08d)
        );

        bands.add(EO.Band.build()
                .name("B7")
                .commonName("swir22")
                .gsd(30)
                .centerWavelength(2.2d)
                .fullWidthHalfMax(0.2d)
        );

        bands.add(EO.Band.build()
                .name("B8")
                .commonName("pan")
                .gsd(15)
                .centerWavelength(0.59d)
                .fullWidthHalfMax(0.18d)
        );

        bands.add(EO.Band.build()
                .name("B9")
                .commonName("cirrus")
                .gsd(30)
                .centerWavelength(1.37d)
                .fullWidthHalfMax(0.02d)
        );

        bands.add(EO.Band.build()
                .name("B10")
                .commonName("lwir11")
                .gsd(100)
                .centerWavelength(10.9d)
                .fullWidthHalfMax(0.8d)
        );

        bands.add(EO.Band.build()
                .name("B11")
                .commonName("lwir12")
                .gsd(100)
                .centerWavelength(12.0d)
                .fullWidthHalfMax(1.0d)
        );

        return bands;
    }

}