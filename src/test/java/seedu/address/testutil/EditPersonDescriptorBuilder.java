package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.date.WeddingDate;
import seedu.address.model.person.Address;
import seedu.address.model.person.Budget;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Partner;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonType;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Price;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditPersonDescriptorBuilder(Person person) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(person.getName());
        descriptor.setPhone(person.getPhone());
        descriptor.setEmail(person.getEmail());
        descriptor.setAddress(person.getAddress());
        descriptor.setWeddingDate(person.getWeddingDate().orElse(null));
        descriptor.setType(person.getType());
        descriptor.setPrice(person.getPrice().orElse(null));
        descriptor.setBudget(person.getBudget().orElse(null));
        descriptor.setPartner(person.getPartner().orElse(null));
        descriptor.setTags(person.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Sets the {@code WeddingDate} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withWeddingDate(String weddingDate) {
        descriptor.setWeddingDate(WeddingDate.parse(weddingDate));
        return this;
    }

    /**
     * Sets the {@code Price} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPrice(String price) {
        descriptor.setPrice(new Price(price));
        return this;
    }

    /**
     * Sets the {@code Budget} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withBudget(String budget) {
        descriptor.setBudget(new Budget(budget));
        return this;
    }

    /** Sets the {@code Partner}. */
    public EditPersonDescriptorBuilder withPartner(String partnerName) {
        descriptor.setPartner(partnerName == null ? null : new Partner(partnerName));
        return this;
    }

    /** Explicitly clears partner (useful when switching to VENDOR). */
    public EditPersonDescriptorBuilder withoutPartner() {
        descriptor.setPartner(null);
        return this;
    }

    /**
     * Sets the {@code PersonType} from a string like "client" or "vendor".
     * Accepts any case; trims and normalises before parsing.
     */
    public EditPersonDescriptorBuilder withType(String type) {
        String normalised = type == null ? null : type.trim().toLowerCase();
        if (normalised != null) {
            descriptor.setType(PersonType.parse(normalised));
        } else {
            descriptor.setType(null);
        }
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
