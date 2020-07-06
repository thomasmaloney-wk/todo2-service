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
public class Todo implements org.apache.thrift.TBase<Todo, Todo._Fields>, java.io.Serializable, Cloneable, Comparable<Todo> {
	private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Todo");

	private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userID", org.apache.thrift.protocol.TType.STRING, (short)1);
	private static final org.apache.thrift.protocol.TField DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("description", org.apache.thrift.protocol.TType.STRING, (short)2);
	private static final org.apache.thrift.protocol.TField DUE_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("dueDate", org.apache.thrift.protocol.TType.I64, (short)3);
	private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)4);
	private static final org.apache.thrift.protocol.TField IS_COMPLETED_FIELD_DESC = new org.apache.thrift.protocol.TField("isCompleted", org.apache.thrift.protocol.TType.BOOL, (short)5);
	private static final org.apache.thrift.protocol.TField IS_PUBLIC_FIELD_DESC = new org.apache.thrift.protocol.TField("isPublic", org.apache.thrift.protocol.TType.BOOL, (short)6);
	private static final org.apache.thrift.protocol.TField NOTES_FIELD_DESC = new org.apache.thrift.protocol.TField("notes", org.apache.thrift.protocol.TType.STRING, (short)7);
	private static final org.apache.thrift.protocol.TField ACCOUNT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("accountID", org.apache.thrift.protocol.TType.STRING, (short)8);

	public String userID;
	public String description;
	public long dueDate;
	public String id;
	public boolean isCompleted;
	public boolean isPublic;
	public String notes;
	public String accountID;
	/** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
	public enum _Fields implements org.apache.thrift.TFieldIdEnum {
		USER_ID((short)1, "userID"),
		DESCRIPTION((short)2, "description"),
		DUE_DATE((short)3, "dueDate"),
		ID((short)4, "id"),
		IS_COMPLETED((short)5, "isCompleted"),
		IS_PUBLIC((short)6, "isPublic"),
		NOTES((short)7, "notes"),
		ACCOUNT_ID((short)8, "accountID")
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
				case 1: // USER_ID
					return USER_ID;
				case 2: // DESCRIPTION
					return DESCRIPTION;
				case 3: // DUE_DATE
					return DUE_DATE;
				case 4: // ID
					return ID;
				case 5: // IS_COMPLETED
					return IS_COMPLETED;
				case 6: // IS_PUBLIC
					return IS_PUBLIC;
				case 7: // NOTES
					return NOTES;
				case 8: // ACCOUNT_ID
					return ACCOUNT_ID;
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
	private static final int __DUEDATE_ISSET_ID = 0;
	private static final int __ISCOMPLETED_ISSET_ID = 1;
	private static final int __ISPUBLIC_ISSET_ID = 2;
	private byte __isset_bitfield = 0;
	public Todo() {
	}

	public Todo(
		String userID,
		String description,
		long dueDate,
		String id,
		boolean isCompleted,
		boolean isPublic,
		String notes,
		String accountID) {
		this();
		this.userID = userID;
		this.description = description;
		this.dueDate = dueDate;
		setDueDateIsSet(true);
		this.id = id;
		this.isCompleted = isCompleted;
		setIsCompletedIsSet(true);
		this.isPublic = isPublic;
		setIsPublicIsSet(true);
		this.notes = notes;
		this.accountID = accountID;
	}

	/**
	 * Performs a deep copy on <i>other</i>.
	 */
	public Todo(Todo other) {
		__isset_bitfield = other.__isset_bitfield;
		if (other.isSetUserID()) {
			this.userID = other.userID;
		}
		if (other.isSetDescription()) {
			this.description = other.description;
		}
		this.dueDate = other.dueDate;
		if (other.isSetId()) {
			this.id = other.id;
		}
		this.isCompleted = other.isCompleted;
		this.isPublic = other.isPublic;
		if (other.isSetNotes()) {
			this.notes = other.notes;
		}
		if (other.isSetAccountID()) {
			this.accountID = other.accountID;
		}
	}

	public Todo deepCopy() {
		return new Todo(this);
	}

	@Override
	public void clear() {
		this.userID = null;

		this.description = null;

		setDueDateIsSet(false);
		this.dueDate = 0L;

		this.id = null;

		setIsCompletedIsSet(false);
		this.isCompleted = false;

		setIsPublicIsSet(false);
		this.isPublic = false;

		this.notes = null;

		this.accountID = null;

	}

	public String getUserID() {
		return this.userID;
	}

	public Todo setUserID(String userID) {
		this.userID = userID;
		return this;
	}

	public void unsetUserID() {
		this.userID = null;
	}

	/** Returns true if field userID is set (has been assigned a value) and false otherwise */
	public boolean isSetUserID() {
		return this.userID != null;
	}

	public void setUserIDIsSet(boolean value) {
		if (!value) {
			this.userID = null;
		}
	}

	public String getDescription() {
		return this.description;
	}

	public Todo setDescription(String description) {
		this.description = description;
		return this;
	}

	public void unsetDescription() {
		this.description = null;
	}

	/** Returns true if field description is set (has been assigned a value) and false otherwise */
	public boolean isSetDescription() {
		return this.description != null;
	}

	public void setDescriptionIsSet(boolean value) {
		if (!value) {
			this.description = null;
		}
	}

	public long getDueDate() {
		return this.dueDate;
	}

	public Todo setDueDate(long dueDate) {
		this.dueDate = dueDate;
		setDueDateIsSet(true);
		return this;
	}

	public void unsetDueDate() {
		__isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DUEDATE_ISSET_ID);
	}

	/** Returns true if field dueDate is set (has been assigned a value) and false otherwise */
	public boolean isSetDueDate() {
		return EncodingUtils.testBit(__isset_bitfield, __DUEDATE_ISSET_ID);
	}

	public void setDueDateIsSet(boolean value) {
		__isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DUEDATE_ISSET_ID, value);
	}

	public String getId() {
		return this.id;
	}

	public Todo setId(String id) {
		this.id = id;
		return this;
	}

	public void unsetId() {
		this.id = null;
	}

	/** Returns true if field id is set (has been assigned a value) and false otherwise */
	public boolean isSetId() {
		return this.id != null;
	}

	public void setIdIsSet(boolean value) {
		if (!value) {
			this.id = null;
		}
	}

	public boolean isIsCompleted() {
		return this.isCompleted;
	}

	public Todo setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
		setIsCompletedIsSet(true);
		return this;
	}

	public void unsetIsCompleted() {
		__isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISCOMPLETED_ISSET_ID);
	}

	/** Returns true if field isCompleted is set (has been assigned a value) and false otherwise */
	public boolean isSetIsCompleted() {
		return EncodingUtils.testBit(__isset_bitfield, __ISCOMPLETED_ISSET_ID);
	}

	public void setIsCompletedIsSet(boolean value) {
		__isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISCOMPLETED_ISSET_ID, value);
	}

	public boolean isIsPublic() {
		return this.isPublic;
	}

	public Todo setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
		setIsPublicIsSet(true);
		return this;
	}

	public void unsetIsPublic() {
		__isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISPUBLIC_ISSET_ID);
	}

	/** Returns true if field isPublic is set (has been assigned a value) and false otherwise */
	public boolean isSetIsPublic() {
		return EncodingUtils.testBit(__isset_bitfield, __ISPUBLIC_ISSET_ID);
	}

	public void setIsPublicIsSet(boolean value) {
		__isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISPUBLIC_ISSET_ID, value);
	}

	public String getNotes() {
		return this.notes;
	}

	public Todo setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public void unsetNotes() {
		this.notes = null;
	}

	/** Returns true if field notes is set (has been assigned a value) and false otherwise */
	public boolean isSetNotes() {
		return this.notes != null;
	}

	public void setNotesIsSet(boolean value) {
		if (!value) {
			this.notes = null;
		}
	}

	public String getAccountID() {
		return this.accountID;
	}

	public Todo setAccountID(String accountID) {
		this.accountID = accountID;
		return this;
	}

	public void unsetAccountID() {
		this.accountID = null;
	}

	/** Returns true if field accountID is set (has been assigned a value) and false otherwise */
	public boolean isSetAccountID() {
		return this.accountID != null;
	}

	public void setAccountIDIsSet(boolean value) {
		if (!value) {
			this.accountID = null;
		}
	}

	public void setFieldValue(_Fields field, Object value) {
		switch (field) {
		case USER_ID:
			if (value == null) {
				unsetUserID();
			} else {
				setUserID((String)value);
			}
			break;

		case DESCRIPTION:
			if (value == null) {
				unsetDescription();
			} else {
				setDescription((String)value);
			}
			break;

		case DUE_DATE:
			if (value == null) {
				unsetDueDate();
			} else {
				setDueDate((Long)value);
			}
			break;

		case ID:
			if (value == null) {
				unsetId();
			} else {
				setId((String)value);
			}
			break;

		case IS_COMPLETED:
			if (value == null) {
				unsetIsCompleted();
			} else {
				setIsCompleted((Boolean)value);
			}
			break;

		case IS_PUBLIC:
			if (value == null) {
				unsetIsPublic();
			} else {
				setIsPublic((Boolean)value);
			}
			break;

		case NOTES:
			if (value == null) {
				unsetNotes();
			} else {
				setNotes((String)value);
			}
			break;

		case ACCOUNT_ID:
			if (value == null) {
				unsetAccountID();
			} else {
				setAccountID((String)value);
			}
			break;

		}
	}

	public Object getFieldValue(_Fields field) {
		switch (field) {
		case USER_ID:
			return getUserID();

		case DESCRIPTION:
			return getDescription();

		case DUE_DATE:
			return getDueDate();

		case ID:
			return getId();

		case IS_COMPLETED:
			return isIsCompleted();

		case IS_PUBLIC:
			return isIsPublic();

		case NOTES:
			return getNotes();

		case ACCOUNT_ID:
			return getAccountID();

		}
		throw new IllegalStateException();
	}

	/** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
	public boolean isSet(_Fields field) {
		if (field == null) {
			throw new IllegalArgumentException();
		}

		switch (field) {
		case USER_ID:
			return isSetUserID();
		case DESCRIPTION:
			return isSetDescription();
		case DUE_DATE:
			return isSetDueDate();
		case ID:
			return isSetId();
		case IS_COMPLETED:
			return isSetIsCompleted();
		case IS_PUBLIC:
			return isSetIsPublic();
		case NOTES:
			return isSetNotes();
		case ACCOUNT_ID:
			return isSetAccountID();
		}
		throw new IllegalStateException();
	}

	@Override
	public boolean equals(Object that) {
		if (that == null)
			return false;
		if (that instanceof Todo)
			return this.equals((Todo)that);
		return false;
	}

	public boolean equals(Todo that) {
		if (that == null)
			return false;
		if (!Objects.equals(this.userID, that.userID))
			return false;
		if (!Objects.equals(this.description, that.description))
			return false;
		if (this.dueDate != that.dueDate)
			return false;
		if (!Objects.equals(this.id, that.id))
			return false;
		if (this.isCompleted != that.isCompleted)
			return false;
		if (this.isPublic != that.isPublic)
			return false;
		if (!Objects.equals(this.notes, that.notes))
			return false;
		if (!Objects.equals(this.accountID, that.accountID))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		List<Object> list = new ArrayList<Object>();

		boolean present_userID = true && (isSetUserID());
		list.add(present_userID);
		if (present_userID)
			list.add(userID);

		boolean present_description = true && (isSetDescription());
		list.add(present_description);
		if (present_description)
			list.add(description);

		boolean present_dueDate = true;
		list.add(present_dueDate);
		if (present_dueDate)
			list.add(dueDate);

		boolean present_id = true && (isSetId());
		list.add(present_id);
		if (present_id)
			list.add(id);

		boolean present_isCompleted = true;
		list.add(present_isCompleted);
		if (present_isCompleted)
			list.add(isCompleted);

		boolean present_isPublic = true;
		list.add(present_isPublic);
		if (present_isPublic)
			list.add(isPublic);

		boolean present_notes = true && (isSetNotes());
		list.add(present_notes);
		if (present_notes)
			list.add(notes);

		boolean present_accountID = true && (isSetAccountID());
		list.add(present_accountID);
		if (present_accountID)
			list.add(accountID);

		return list.hashCode();
	}

	@Override
	public int compareTo(Todo other) {
		if (!getClass().equals(other.getClass())) {
			return getClass().getName().compareTo(other.getClass().getName());
		}

		int lastComparison = 0;

		lastComparison = Boolean.compare(isSetUserID(), other.isSetUserID());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetUserID()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userID, other.userID);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.compare(isSetDescription(), other.isSetDescription());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetDescription()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.description, other.description);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.compare(isSetDueDate(), other.isSetDueDate());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetDueDate()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dueDate, other.dueDate);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.compare(isSetId(), other.isSetId());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetId()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.compare(isSetIsCompleted(), other.isSetIsCompleted());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetIsCompleted()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isCompleted, other.isCompleted);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.compare(isSetIsPublic(), other.isSetIsPublic());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetIsPublic()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isPublic, other.isPublic);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.compare(isSetNotes(), other.isSetNotes());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetNotes()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.notes, other.notes);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.compare(isSetAccountID(), other.isSetAccountID());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetAccountID()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.accountID, other.accountID);
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
		new TodoStandardScheme().read(iprot, this);
	}

	public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
		if (oprot.getScheme() != StandardScheme.class) {
			throw new UnsupportedOperationException();
		}
		new TodoStandardScheme().write(oprot, this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Todo(");
		boolean first = true;

		sb.append("userID:");
		sb.append(this.userID);
		first = false;
		if (!first) sb.append(", ");
		sb.append("description:");
		sb.append(this.description);
		first = false;
		if (!first) sb.append(", ");
		sb.append("dueDate:");
		sb.append(this.dueDate);
		first = false;
		if (!first) sb.append(", ");
		sb.append("id:");
		sb.append(this.id);
		first = false;
		if (!first) sb.append(", ");
		sb.append("isCompleted:");
		sb.append(this.isCompleted);
		first = false;
		if (!first) sb.append(", ");
		sb.append("isPublic:");
		sb.append(this.isPublic);
		first = false;
		if (!first) sb.append(", ");
		sb.append("notes:");
		sb.append(this.notes);
		first = false;
		if (!first) sb.append(", ");
		sb.append("accountID:");
		sb.append(this.accountID);
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

	private static class TodoStandardScheme extends StandardScheme<Todo> {

		public void read(org.apache.thrift.protocol.TProtocol iprot, Todo struct) throws org.apache.thrift.TException {
			org.apache.thrift.protocol.TField schemeField;
			iprot.readStructBegin();
			while (true) {
				schemeField = iprot.readFieldBegin();
				if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
					break;
				}
				switch (schemeField.id) {
					case 1: // USER_ID
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.userID = iprot.readString();
							struct.setUserIDIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 2: // DESCRIPTION
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.description = iprot.readString();
							struct.setDescriptionIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 3: // DUE_DATE
						if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
							struct.dueDate = iprot.readI64();
							struct.setDueDateIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 4: // ID
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.id = iprot.readString();
							struct.setIdIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 5: // IS_COMPLETED
						if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
							struct.isCompleted = iprot.readBool();
							struct.setIsCompletedIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 6: // IS_PUBLIC
						if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
							struct.isPublic = iprot.readBool();
							struct.setIsPublicIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 7: // NOTES
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.notes = iprot.readString();
							struct.setNotesIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 8: // ACCOUNT_ID
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.accountID = iprot.readString();
							struct.setAccountIDIsSet(true);
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

		public void write(org.apache.thrift.protocol.TProtocol oprot, Todo struct) throws org.apache.thrift.TException {
			struct.validate();

			oprot.writeStructBegin(STRUCT_DESC);
			if (struct.isSetUserID()) {
				oprot.writeFieldBegin(USER_ID_FIELD_DESC);
				String elem0 = struct.userID;
				oprot.writeString(elem0);
				oprot.writeFieldEnd();
			}
			if (struct.isSetDescription()) {
				oprot.writeFieldBegin(DESCRIPTION_FIELD_DESC);
				String elem1 = struct.description;
				oprot.writeString(elem1);
				oprot.writeFieldEnd();
			}
			oprot.writeFieldBegin(DUE_DATE_FIELD_DESC);
			long elem2 = struct.dueDate;
			oprot.writeI64(elem2);
			oprot.writeFieldEnd();
			if (struct.isSetId()) {
				oprot.writeFieldBegin(ID_FIELD_DESC);
				String elem3 = struct.id;
				oprot.writeString(elem3);
				oprot.writeFieldEnd();
			}
			oprot.writeFieldBegin(IS_COMPLETED_FIELD_DESC);
			boolean elem4 = struct.isCompleted;
			oprot.writeBool(elem4);
			oprot.writeFieldEnd();
			oprot.writeFieldBegin(IS_PUBLIC_FIELD_DESC);
			boolean elem5 = struct.isPublic;
			oprot.writeBool(elem5);
			oprot.writeFieldEnd();
			if (struct.isSetNotes()) {
				oprot.writeFieldBegin(NOTES_FIELD_DESC);
				String elem6 = struct.notes;
				oprot.writeString(elem6);
				oprot.writeFieldEnd();
			}
			if (struct.isSetAccountID()) {
				oprot.writeFieldBegin(ACCOUNT_ID_FIELD_DESC);
				String elem7 = struct.accountID;
				oprot.writeString(elem7);
				oprot.writeFieldEnd();
			}
			oprot.writeFieldStop();
			oprot.writeStructEnd();
		}

	}

}
