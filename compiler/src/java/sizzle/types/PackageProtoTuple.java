package sizzle.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A {@link SizzleProtoTuple}.
 * 
 * @author rdyer
 * 
 */
public class PackageProtoTuple extends SizzleProtoTuple {
	private final static List<SizzleType> members = new ArrayList<SizzleType>();
	private final static Map<String, Integer> names = new HashMap<String, Integer>();

	static {
		names.put("name", 0);
		members.add(new SizzleString());

		names.put("types", 0);
		members.add(new SizzleProtoList(new TypeProtoTuple()));
	}

	/**
	 * Construct a ProjectProtoTuple.
	 */
	public PackageProtoTuple() {
		super(members, names);
	}

	@Override
	public String toJavaType() {
		return "sizzle.types.Ast.Package";
	}
}