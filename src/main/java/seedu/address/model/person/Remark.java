package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; valid as declared in {@link #isValidRemark(String)}.
 */
public class Remark {

    public static final String MESSAGE_CONSTRAINTS =
            "Remarks can be empty or any text; if non-empty, it must not start with whitespace.";

    // Allow "" (empty) OR any string whose first char is not whitespace
    public static final String VALIDATION_REGEX = "(?s)^$|[^\\s].*";

    public final String value;

    /**
     * Constructs a {@code Remark}.
     *
     * @param remark A valid remark.
     */
    public Remark(String remark) {
        requireNonNull(remark);
        checkArgument(isValidRemark(remark), MESSAGE_CONSTRAINTS);
        value = remark;
    }

    /** Returns true if a given string is a valid remark. */
    public static boolean isValidRemark(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override public String toString() { return value; }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Remark && value.equals(((Remark) other).value));
    }

    @Override public int hashCode() { return value.hashCode(); }
}
