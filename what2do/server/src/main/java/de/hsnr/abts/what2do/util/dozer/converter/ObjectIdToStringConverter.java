package de.hsnr.abts.what2do.util.dozer.converter;

import org.bson.types.ObjectId;
import org.dozer.DozerConverter;

public class ObjectIdToStringConverter extends DozerConverter<ObjectId, String> {

	public ObjectIdToStringConverter() {
		this(ObjectId.class, String.class);
	}

	public ObjectIdToStringConverter(Class<ObjectId> prototypeA,
			Class<String> prototypeB) {
		super(prototypeA, prototypeB);

	}

	@Override
	public String convertTo(ObjectId source, String destination) {
		return source.toString();
	}

	@Override
	public ObjectId convertFrom(String source, ObjectId destination) {
		return new ObjectId(source);
	}

}
