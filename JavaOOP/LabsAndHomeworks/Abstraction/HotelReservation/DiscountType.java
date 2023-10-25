package Abstraction.HotelReservation;

public enum DiscountType {

    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1);

    private final double percent;

    DiscountType(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public static DiscountType fromString(String discountType) {
        switch (discountType) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Cannot find discount type " + discountType);
        }
    }
}
