package kata.supermarket;

/**
 * Every distinct item that can be purchased from a supermarket should have a
 * unique identifier which discounts can be applied to. These can be defined
 * within this enumeration, so that they can be referenced assigned to
 * individual items and also referenced by specific discount rules.
 * <p>
 * <b>NOTE:</b> Currently we have just used a number of letters but this enum
 * could be anything where we can generate enough unique values.
 * 
 * @author simon.seagroatt
 *
 */
public enum ItemType {
	A, B, C, D, E, F, G, H, I, J
}
