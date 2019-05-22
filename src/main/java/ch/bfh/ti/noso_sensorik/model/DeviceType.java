package ch.bfh.ti.noso_sensorik.model;

import java.util.HashMap;
import java.util.Map;

public enum DeviceType {
    STATIONARY_BED(1),
    STATIONARY_DISPENSER(2),
    MOBILE_SCRUB_BOTTLE(3),
    SEMI_STATIONARY_DISPENSER(4);

    private final int type;
    private static Map<Object, Object> map = new HashMap<>();

    DeviceType(int type) {
        this.type = type;
    }

    static {
        for (DeviceType beaconType : DeviceType.values()) {
            map.put(beaconType.type, beaconType);
        }
    }

    public static DeviceType valueOf(int beaconType) {
        return (DeviceType) map.get(beaconType);
    }

    public int getValue() {
        return type;
    }

    public String toString() {
        return Integer.toString(type);
    }

}