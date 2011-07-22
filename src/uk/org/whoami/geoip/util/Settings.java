package uk.org.whoami.geoip.util;

import org.bukkit.util.config.Configuration;

/**
 *
 * @author Sebastian Köhler <sebkoehler@whoami.org.uk>
 */
public class Settings {

    final String CITYDATABASEPATH = "./plugins/GeoIPTools/GeoLiteCity.dat";
    final String COUNTRYDATABASEPATH = "./plugins/GeoIPTools/GeoIP.dat";
    final String IPV6DATABASEBATH = "./plugins/GeoIPTools/GeoIPv6.dat";
    private Configuration conf;

    /**
     *
     * @param conf
     */
    public Settings(Configuration conf) {
        this.conf = conf;
        conf.load();
        write();
    }

    /**
     *
     */
    public final void write() {
        getIPv6DatabaseURL();
        getCityDatabaseURL();
        getCountryDatabaseURL();
        getLastUpdated();
        conf.save();
    }

    /**
     *
     * @param lastUpdated
     */
    public void setLastUpdated(long lastUpdated) {
        String key = "Update:lastUpdated";
        conf.setProperty(key, String.valueOf(lastUpdated));
    }

    /**
     *
     * @return
     */
    public long getLastUpdated() {
        String key = "Update:lastUpdated";
        if(conf.getString(key) == null) {
            conf.setProperty(key, "0");
        }
        return Long.parseLong(conf.getString(key));
    }

    /**
     *
     * @return
     */
    public String getIPv6DatabaseURL() {
        String key = "URL.IPv6Database";
        if(conf.getString(key) == null) {
            conf.setProperty(key,
                    "http://geolite.maxmind.com/download/geoip/database/GeoIPv6.dat.gz");
        }
        return conf.getString(key);
    }

    /**
     *
     * @return
     */
    public String getCityDatabaseURL() {
        String key = "URL.CityDatabase";
        if(conf.getString(key) == null) {
            conf.setProperty(key,
                    "http://geolite.maxmind.com/download/geoip/database/GeoLiteCity.dat.gz");
        }
        return conf.getString(key);
    }

    /**
     *
     * @return
     */
    public String getCountryDatabaseURL() {
        String key = "URL.CountryDatabase";
        if(conf.getString(key) == null) {
            conf.setProperty(key,
                    "http://geolite.maxmind.com/download/geoip/database/GeoLiteCountry/GeoIP.dat.gz");
        }
        return conf.getString(key);
    }

    /**
     *
     * @return
     */
    public String getIPv6DatabasePath() {
        String key = "Path.IPv6Database";
        if(conf.getString(key) == null) {
            return this.IPV6DATABASEBATH;
        }
        return conf.getString(key);
    }

    /**
     *
     * @return
     */
    public String getCityDatabasePath() {
        String key = "Path.cityDatabase";
        if(conf.getString(key) == null) {
            return this.CITYDATABASEPATH;
        }
        return conf.getString(key);
    }

    /**
     *
     * @return
     */
    public String getCountryDatabasePath() {
        String key = "Path.countryDatabase";
        if(conf.getString(key) == null) {
            return this.COUNTRYDATABASEPATH;
        }
        return conf.getString(key);
    }
}