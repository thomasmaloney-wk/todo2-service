/**
 * Autogenerated by Frugal Compiler (3.9.5)
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package todo_transport.v1;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.util.Objects;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Autogenerated by Frugal Compiler (3.9.5)")
public class TodoQueryParams implements org.apache.thrift.TBase<TodoQueryParams, TodoQueryParams._Fields>, java.io.Serializable, Cloneable, Comparable<TodoQueryParams> {
	private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TodoQueryParams");

	private static final org.apache.thrift.protocol.TField INCLUDE_PUBLIC_FIELD_DESC = new org.apache.thrift.protocol.TField("includePublic", org.apache.thrift.protocol.TType.BOOL, (short)1);
	private static final org.apache.thrift.protocol.TField INCLUDE_PRIVATE_FIELD_DESC = new org.apache.thrift.protocol.TField("includePrivate", org.apache.thrift.protocol.TType.BOOL, (short)2);
	private static final org.apache.thrift.protocol.TField INCLUDE_COMPLETE_FIELD_DESC = new org.apache.thrift.protocol.TField("includeComplete", org.apache.thrift.protocol.TType.BOOL, (short)3);
	private static final org.apache.thrift.protocol.TField INCLUDE_INCOMPLETE_FIELD_DESC = new org.apache.thrift.protocol.TField("includeIncomplete", org.apache.thrift.protocol.TType.BOOL, (short)4);

	public boolean includePublic;
	public boolean includePrivate;
	public boolean includeComplete;
	public boolean includeIncomplete;
	/** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
	public enum _Fields implements org.apache.thrift.TFieldIdEnum {
		INCLUDE_PUBLIC((short)1, "includePublic"),
		INCLUDE_PRIVATE((short)2, "includePrivate"),
		INCLUDE_COMPLETE((short)3, "includeComplete"),
		INCLUDE_INCOMPLETE((short)4, "includeIncomplete")
		;

		private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

		static {
			for (_Fields field : EnumSet.allOf(_Fields.class)) {
				byName.put(field.getFieldName(), field);
			}
		}

		/**
		 * Find the _Fields constant that matches fieldId, or null if its not found.
		 */
		public static _Fields findByThriftId(int fieldId) {
			switch(fieldId) {
				case 1: // INCLUDE_PUBLIC
					return INCLUDE_PUBLIC;
				case 2: // INCLUDE_PRIVATE
					return INCLUDE_PRIVATE;
				case 3: // INCLUDE_COMPLETE
					return INCLUDE_COMPLETE;
				case 4: // INCLUDE_INCOMPLETE
					return INCLUDE_INCOMPLETE;
				default:
					return null;
			}
		}

		/**
		 * Find the _Fields constant that matches fieldId, throwing an exception
		 * if it is not found.
		 */
		public static _Fields findByThriftIdOrThrow(int fieldId) {
			_Fields fields = findByThriftId(fieldId);
			if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
			return fields;
		}

		/**
		 * Find the _Fields constant that matches name, or null if its not found.
		 */
		public static _Fields findByName(String name) {
			return byName.get(name);
		}

		private final short _thriftId;
		private final String _fieldName;

		_Fields(short thriftId, String fieldName) {
			_thriftId = thriftId;
			_fieldName = fieldName;
		}

		public short getThriftFieldId() {
			return _thriftId;
		}

		public String getFieldName() {
			return _fieldName;
		}
	}

	// isset id assignments
	private static final int __INCLUDEPUBLIC_ISSET_ID = 0;
	private static final int __INCLUDEPRIVATE_ISSET_ID = 1;
	private static final int __INCLUDECOMPLETE_ISSET_ID = 2;
	private static final int __INCLUDEINCOMPLETE_ISSET_ID = 3;
	private byte __isset_bitfield = 0;
	public TodoQueryParams() {
	}

	public TodoQueryParams(
		boolean includePublic,
		boolean includePrivate,
		boolean includeComplete,
		boolean includeIncomplete) {
		this();
		this.includePublic = includePublic;
		setIncludePublicIsSet(true);
		this.includePrivate = includePrivate;
		setIncludePrivateIsSet(true);
		this.includeComplete = includeComplete;
		setIncludeCompleteIsSet(true);
		this.includeIncomplete = includeIncomplete;
		setIncludeIncompleteIsSet(true);
	}

	/**
	 * Performs a deep copy on <i>other</i>.
	 */
	public TodoQueryParams(TodoQueryParams other) {
		__isset_bitfield = other.__isset_bitfield;
		this.includePublic = other.includePublic;
		this.includePrivate = other.includePrivate;
		this.includeComplete = other.includeComplete;
		this.includeIncomplete = other.includeIncomplete;
	}

	public TodoQueryParams deepCopy() {
		return new TodoQueryParams(this);
	}

	@Override
	public void clear() {
		setIncludePublicIsSet(false);
		this.includePublic = false;

		setIncludePrivateIsSet(false);
		this.includePrivate = false;

		setIncludeCompleteIsSet(false);
		this.includeComplete = false;

		setIncludeIncompleteIsSet(false);
		this.includeIncomplete = false;

	}

	public boolean isIncludePublic() {
		return this.includePublic;
	}

	public TodoQueryParams setIncludePublic(boolean includePublic) {
		this.includePublic = includePublic;
		setIncludePublicIsSet(true);
		return this;
	}

	public void unsetIncludePublic() {
		__isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __INCLUDEPUBLIC_ISSET_ID);
	}

	/** Returns true if field includePublic is set (has been assigned a value) and false otherwise */
	public boolean isSetIncludePublic() {
		return EncodingUtils.testBit(__isset_bitfield, __INCLUDEPUBLIC_ISSET_ID);
	}

	public void setIncludePublicIsSet(boolean value) {
		__isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __INCLUDEPUBLIC_ISSET_ID, value);
	}

	public boolean isIncludePrivate() {
		return this.includePrivate;
	}

	public TodoQueryParams setIncludePrivate(boolean includePrivate) {
		this.includePrivate = includePrivate;
		setIncludePrivateIsSet(true);
		return this;
	}

	public void unsetIncludePrivate() {
		__isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __INCLUDEPRIVATE_ISSET_ID);
	}

	/** Returns true if field includePrivate is set (has been assigned a value) and false otherwise */
	public boolean isSetIncludePrivate() {
		return EncodingUtils.testBit(__isset_bitfield, __INCLUDEPRIVATE_ISSET_ID);
	}

	public void setIncludePrivateIsSet(boolean value) {
		__isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __INCLUDEPRIVATE_ISSET_ID, value);
	}

	public boolean isIncludeComplete() {
		return this.includeComplete;
	}

	public TodoQueryParams setIncludeComplete(boolean includeComplete) {
		this.includeComplete = includeComplete;
		setIncludeCompleteIsSet(true);
		return this;
	}

	public void unsetIncludeComplete() {
		__isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __INCLUDECOMPLETE_ISSET_ID);
	}

	/** Returns true if field includeComplete is set (has been assigned a value) and false otherwise */
	public boolean isSetIncludeComplete() {
		return EncodingUtils.testBit(__isset_bitfield, __INCLUDECOMPLETE_ISSET_ID);
	}

	public void setIncludeCompleteIsSet(boolean value) {
		__isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __INCLUDECOMPLETE_ISSET_ID, value);
	}

	public boolean isIncludeIncomplete() {
		return this.includeIncomplete;
	}

	public TodoQueryParams setIncludeIncomplete(boolean includeIncomplete) {
		this.includeIncomplete = includeIncomplete;
		setIncludeIncompleteIsSet(true);
		return this;
	}

	public void unsetIncludeIncomplete() {
		__isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __INCLUDEINCOMPLETE_ISSET_ID);
	}

	/** Returns true if field includeIncomplete is set (has been assigned a value) and false otherwise */
	public boolean isSetIncludeIncomplete() {
		return EncodingUtils.testBit(__isset_bitfield, __INCLUDEINCOMPLETE_ISSET_ID);
	}

	public void setIncludeIncompleteIsSet(boolean value) {
		__isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __INCLUDEINCOMPLETE_ISSET_ID, value);
	}

	public void setFieldValue(_Fields field, Object value) {
		switch (field) {
		case INCLUDE_PUBLIC:
			if (value == null) {
				unsetIncludePublic();
			} else {
				setIncludePublic((Boolean)value);
			}
			break;

		case INCLUDE_PRIVATE:
			if (value == null) {
				unsetIncludePrivate();
			} else {
				setIncludePrivate((Boolean)value);
			}
			break;

		case INCLUDE_COMPLETE:
			if (value == null) {
				unsetIncludeComplete();
			} else {
				setIncludeComplete((Boolean)value);
			}
			break;

		case INCLUDE_INCOMPLETE:
			if (value == null) {
				unsetIncludeIncomplete();
			} else {
				setIncludeIncomplete((Boolean)value);
			}
			break;

		}
	}

	public Object getFieldValue(_Fields field) {
		switch (field) {
		case INCLUDE_PUBLIC:
			return isIncludePublic();

		case INCLUDE_PRIVATE:
			return isIncludePrivate();

		case INCLUDE_COMPLETE:
			return isIncludeComplete();

		case INCLUDE_INCOMPLETE:
			return isIncludeIncomplete();

		}
		throw new IllegalStateException();
	}

	/** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
	public boolean isSet(_Fields field) {
		if (field == null) {
			throw new IllegalArgumentException();
		}

		switch (field) {
		case INCLUDE_PUBLIC:
			return isSetIncludePublic();
		case INCLUDE_PRIVATE:
			return isSetIncludePrivate();
		case INCLUDE_COMPLETE:
			return isSetIncludeComplete();
		case INCLUDE_INCOMPLETE:
			return isSetIncludeIncomplete();
		}
		throw new IllegalStateException();
	}

	@Override
	public boolean equals(Object that) {
		if (that == null)
			return false;
		if (that instanceof TodoQueryParams)
			return this.equals((TodoQueryParams)that);
		return false;
	}

	public boolean equals(TodoQueryParams that) {
		if (that == null)
			return false;
		if (this.includePublic != that.includePublic)
			return false;
		if (this.includePrivate != that.includePrivate)
			return false;
		if (this.includeComplete != that.includeComplete)
			return false;
		if (this.includeIncomplete != that.includeIncomplete)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		List<Object> list = new ArrayList<Object>();

		boolean present_includePublic = true;
		list.add(present_includePublic);
		if (present_includePublic)
			list.add(includePublic);

		boolean present_includePrivate = true;
		list.add(present_includePrivate);
		if (present_includePrivate)
			list.add(includePrivate);

		boolean present_includeComplete = true;
		list.add(present_includeComplete);
		if (present_includeComplete)
			list.add(includeComplete);

		boolean present_includeIncomplete = true;
		list.add(present_includeIncomplete);
		if (present_includeIncomplete)
			list.add(includeIncomplete);

		return list.hashCode();
	}

	@Override
	public int compareTo(TodoQueryParams other) {
		if (!getClass().equals(other.getClass())) {
			return getClass().getName().compareTo(other.getClass().getName());
		}

		int lastComparison = 0;

		lastComparison = Boolean.compare(isSetIncludePublic(), other.isSetIncludePublic());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetIncludePublic()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.includePublic, other.includePublic);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.compare(isSetIncludePrivate(), other.isSetIncludePrivate());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetIncludePrivate()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.includePrivate, other.includePrivate);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.compare(isSetIncludeComplete(), other.isSetIncludeComplete());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetIncludeComplete()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.includeComplete, other.includeComplete);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.compare(isSetIncludeIncomplete(), other.isSetIncludeIncomplete());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetIncludeIncomplete()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.includeIncomplete, other.includeIncomplete);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		return 0;
	}

	public _Fields fieldForId(int fieldId) {
		return _Fields.findByThriftId(fieldId);
	}

	public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
		if (iprot.getScheme() != StandardScheme.class) {
			throw new UnsupportedOperationException();
		}
		new TodoQueryParamsStandardScheme().read(iprot, this);
	}

	public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
		if (oprot.getScheme() != StandardScheme.class) {
			throw new UnsupportedOperationException();
		}
		new TodoQueryParamsStandardScheme().write(oprot, this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("TodoQueryParams(");
		boolean first = true;

		sb.append("includePublic:");
		sb.append(this.includePublic);
		first = false;
		if (!first) sb.append(", ");
		sb.append("includePrivate:");
		sb.append(this.includePrivate);
		first = false;
		if (!first) sb.append(", ");
		sb.append("includeComplete:");
		sb.append(this.includeComplete);
		first = false;
		if (!first) sb.append(", ");
		sb.append("includeIncomplete:");
		sb.append(this.includeIncomplete);
		first = false;
		sb.append(")");
		return sb.toString();
	}

	public void validate() throws org.apache.thrift.TException {
		// check for required fields
		// check for sub-struct validity
	}

	private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
		try {
			write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
		} catch (org.apache.thrift.TException te) {
			throw new java.io.IOException(te);
		}
	}

	private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
		try {
			// it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
			__isset_bitfield = 0;
			read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
		} catch (org.apache.thrift.TException te) {
			throw new java.io.IOException(te);
		}
	}

	private static class TodoQueryParamsStandardScheme extends StandardScheme<TodoQueryParams> {

		public void read(org.apache.thrift.protocol.TProtocol iprot, TodoQueryParams struct) throws org.apache.thrift.TException {
			org.apache.thrift.protocol.TField schemeField;
			iprot.readStructBegin();
			while (true) {
				schemeField = iprot.readFieldBegin();
				if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
					break;
				}
				switch (schemeField.id) {
					case 1: // INCLUDE_PUBLIC
						if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
							struct.includePublic = iprot.readBool();
							struct.setIncludePublicIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 2: // INCLUDE_PRIVATE
						if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
							struct.includePrivate = iprot.readBool();
							struct.setIncludePrivateIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 3: // INCLUDE_COMPLETE
						if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
							struct.includeComplete = iprot.readBool();
							struct.setIncludeCompleteIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 4: // INCLUDE_INCOMPLETE
						if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
							struct.includeIncomplete = iprot.readBool();
							struct.setIncludeIncompleteIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
				}
				iprot.readFieldEnd();
			}
			iprot.readStructEnd();

			// check for required fields of primitive type, which can't be checked in the validate method
			struct.validate();
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot, TodoQueryParams struct) throws org.apache.thrift.TException {
			struct.validate();

			oprot.writeStructBegin(STRUCT_DESC);
			oprot.writeFieldBegin(INCLUDE_PUBLIC_FIELD_DESC);
			boolean elem8 = struct.includePublic;
			oprot.writeBool(elem8);
			oprot.writeFieldEnd();
			oprot.writeFieldBegin(INCLUDE_PRIVATE_FIELD_DESC);
			boolean elem9 = struct.includePrivate;
			oprot.writeBool(elem9);
			oprot.writeFieldEnd();
			oprot.writeFieldBegin(INCLUDE_COMPLETE_FIELD_DESC);
			boolean elem10 = struct.includeComplete;
			oprot.writeBool(elem10);
			oprot.writeFieldEnd();
			oprot.writeFieldBegin(INCLUDE_INCOMPLETE_FIELD_DESC);
			boolean elem11 = struct.includeIncomplete;
			oprot.writeBool(elem11);
			oprot.writeFieldEnd();
			oprot.writeFieldStop();
			oprot.writeStructEnd();
		}

	}

}