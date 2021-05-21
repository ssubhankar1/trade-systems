/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.tradesystem.tradesystem.model;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class TradeStore extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4497009937002926589L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TradeStore\",\"namespace\":\"com.tradesystems.feeder.schema\",\"fields\":[{\"name\":\"tradeId\",\"type\":\"string\"},{\"name\":\"counterPartyId\",\"type\":\"string\"},{\"name\":\"version\",\"type\":\"int\"},{\"name\":\"bookingId\",\"type\":\"string\"},{\"name\":\"expiredFlag\",\"type\":\"string\"},{\"name\":\"maturityDate\",\"type\":\"int\",\"logicalType\":\"date\"},{\"name\":\"createdDate\",\"type\":\"int\",\"logicalType\":\"date\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TradeStore> ENCODER =
      new BinaryMessageEncoder<TradeStore>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TradeStore> DECODER =
      new BinaryMessageDecoder<TradeStore>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<TradeStore> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<TradeStore> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TradeStore>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this TradeStore to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a TradeStore from a ByteBuffer. */
  public static TradeStore fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public CharSequence tradeId;
  @Deprecated public CharSequence counterPartyId;
  @Deprecated public int version;
  @Deprecated public CharSequence bookingId;
  @Deprecated public CharSequence expiredFlag;
  @Deprecated public int maturityDate;
  @Deprecated public int createdDate;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TradeStore() {}

  /**
   * All-args constructor.
   * @param tradeId The new value for tradeId
   * @param counterPartyId The new value for counterPartyId
   * @param version The new value for version
   * @param bookingId The new value for bookingId
   * @param expiredFlag The new value for expiredFlag
   * @param maturityDate The new value for maturityDate
   * @param createdDate The new value for createdDate
   */
  public TradeStore(CharSequence tradeId, CharSequence counterPartyId, Integer version, CharSequence bookingId, CharSequence expiredFlag, Integer maturityDate, Integer createdDate) {
    this.tradeId = tradeId;
    this.counterPartyId = counterPartyId;
    this.version = version;
    this.bookingId = bookingId;
    this.expiredFlag = expiredFlag;
    this.maturityDate = maturityDate;
    this.createdDate = createdDate;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return tradeId;
    case 1: return counterPartyId;
    case 2: return version;
    case 3: return bookingId;
    case 4: return expiredFlag;
    case 5: return maturityDate;
    case 6: return createdDate;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: tradeId = (CharSequence)value$; break;
    case 1: counterPartyId = (CharSequence)value$; break;
    case 2: version = (Integer)value$; break;
    case 3: bookingId = (CharSequence)value$; break;
    case 4: expiredFlag = (CharSequence)value$; break;
    case 5: maturityDate = (Integer)value$; break;
    case 6: createdDate = (Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'tradeId' field.
   * @return The value of the 'tradeId' field.
   */
  public CharSequence getTradeId() {
    return tradeId;
  }

  /**
   * Sets the value of the 'tradeId' field.
   * @param value the value to set.
   */
  public void setTradeId(CharSequence value) {
    this.tradeId = value;
  }

  /**
   * Gets the value of the 'counterPartyId' field.
   * @return The value of the 'counterPartyId' field.
   */
  public CharSequence getCounterPartyId() {
    return counterPartyId;
  }

  /**
   * Sets the value of the 'counterPartyId' field.
   * @param value the value to set.
   */
  public void setCounterPartyId(CharSequence value) {
    this.counterPartyId = value;
  }

  /**
   * Gets the value of the 'version' field.
   * @return The value of the 'version' field.
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * Sets the value of the 'version' field.
   * @param value the value to set.
   */
  public void setVersion(Integer value) {
    this.version = value;
  }

  /**
   * Gets the value of the 'bookingId' field.
   * @return The value of the 'bookingId' field.
   */
  public CharSequence getBookingId() {
    return bookingId;
  }

  /**
   * Sets the value of the 'bookingId' field.
   * @param value the value to set.
   */
  public void setBookingId(CharSequence value) {
    this.bookingId = value;
  }

  /**
   * Gets the value of the 'expiredFlag' field.
   * @return The value of the 'expiredFlag' field.
   */
  public CharSequence getExpiredFlag() {
    return expiredFlag;
  }

  /**
   * Sets the value of the 'expiredFlag' field.
   * @param value the value to set.
   */
  public void setExpiredFlag(CharSequence value) {
    this.expiredFlag = value;
  }

  /**
   * Gets the value of the 'maturityDate' field.
   * @return The value of the 'maturityDate' field.
   */
  public Integer getMaturityDate() {
    return maturityDate;
  }

  /**
   * Sets the value of the 'maturityDate' field.
   * @param value the value to set.
   */
  public void setMaturityDate(Integer value) {
    this.maturityDate = value;
  }

  /**
   * Gets the value of the 'createdDate' field.
   * @return The value of the 'createdDate' field.
   */
  public Integer getCreatedDate() {
    return createdDate;
  }

  /**
   * Sets the value of the 'createdDate' field.
   * @param value the value to set.
   */
  public void setCreatedDate(Integer value) {
    this.createdDate = value;
  }

  /**
   * Creates a new TradeStore RecordBuilder.
   * @return A new TradeStore RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new TradeStore RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TradeStore RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    return new Builder(other);
  }

  /**
   * Creates a new TradeStore RecordBuilder by copying an existing TradeStore instance.
   * @param other The existing instance to copy.
   * @return A new TradeStore RecordBuilder
   */
  public static Builder newBuilder(TradeStore other) {
    return new Builder(other);
  }

  /**
   * RecordBuilder for TradeStore instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TradeStore>
    implements org.apache.avro.data.RecordBuilder<TradeStore> {

    private CharSequence tradeId;
    private CharSequence counterPartyId;
    private int version;
    private CharSequence bookingId;
    private CharSequence expiredFlag;
    private int maturityDate;
    private int createdDate;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.tradeId)) {
        this.tradeId = data().deepCopy(fields()[0].schema(), other.tradeId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.counterPartyId)) {
        this.counterPartyId = data().deepCopy(fields()[1].schema(), other.counterPartyId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.version)) {
        this.version = data().deepCopy(fields()[2].schema(), other.version);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.bookingId)) {
        this.bookingId = data().deepCopy(fields()[3].schema(), other.bookingId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.expiredFlag)) {
        this.expiredFlag = data().deepCopy(fields()[4].schema(), other.expiredFlag);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.maturityDate)) {
        this.maturityDate = data().deepCopy(fields()[5].schema(), other.maturityDate);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.createdDate)) {
        this.createdDate = data().deepCopy(fields()[6].schema(), other.createdDate);
        fieldSetFlags()[6] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing TradeStore instance
     * @param other The existing instance to copy.
     */
    private Builder(TradeStore other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.tradeId)) {
        this.tradeId = data().deepCopy(fields()[0].schema(), other.tradeId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.counterPartyId)) {
        this.counterPartyId = data().deepCopy(fields()[1].schema(), other.counterPartyId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.version)) {
        this.version = data().deepCopy(fields()[2].schema(), other.version);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.bookingId)) {
        this.bookingId = data().deepCopy(fields()[3].schema(), other.bookingId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.expiredFlag)) {
        this.expiredFlag = data().deepCopy(fields()[4].schema(), other.expiredFlag);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.maturityDate)) {
        this.maturityDate = data().deepCopy(fields()[5].schema(), other.maturityDate);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.createdDate)) {
        this.createdDate = data().deepCopy(fields()[6].schema(), other.createdDate);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'tradeId' field.
      * @return The value.
      */
    public CharSequence getTradeId() {
      return tradeId;
    }

    /**
      * Sets the value of the 'tradeId' field.
      * @param value The value of 'tradeId'.
      * @return This builder.
      */
    public Builder setTradeId(CharSequence value) {
      validate(fields()[0], value);
      this.tradeId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'tradeId' field has been set.
      * @return True if the 'tradeId' field has been set, false otherwise.
      */
    public boolean hasTradeId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'tradeId' field.
      * @return This builder.
      */
    public Builder clearTradeId() {
      tradeId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'counterPartyId' field.
      * @return The value.
      */
    public CharSequence getCounterPartyId() {
      return counterPartyId;
    }

    /**
      * Sets the value of the 'counterPartyId' field.
      * @param value The value of 'counterPartyId'.
      * @return This builder.
      */
    public Builder setCounterPartyId(CharSequence value) {
      validate(fields()[1], value);
      this.counterPartyId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'counterPartyId' field has been set.
      * @return True if the 'counterPartyId' field has been set, false otherwise.
      */
    public boolean hasCounterPartyId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'counterPartyId' field.
      * @return This builder.
      */
    public Builder clearCounterPartyId() {
      counterPartyId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'version' field.
      * @return The value.
      */
    public Integer getVersion() {
      return version;
    }

    /**
      * Sets the value of the 'version' field.
      * @param value The value of 'version'.
      * @return This builder.
      */
    public Builder setVersion(int value) {
      validate(fields()[2], value);
      this.version = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'version' field has been set.
      * @return True if the 'version' field has been set, false otherwise.
      */
    public boolean hasVersion() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'version' field.
      * @return This builder.
      */
    public Builder clearVersion() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'bookingId' field.
      * @return The value.
      */
    public CharSequence getBookingId() {
      return bookingId;
    }

    /**
      * Sets the value of the 'bookingId' field.
      * @param value The value of 'bookingId'.
      * @return This builder.
      */
    public Builder setBookingId(CharSequence value) {
      validate(fields()[3], value);
      this.bookingId = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'bookingId' field has been set.
      * @return True if the 'bookingId' field has been set, false otherwise.
      */
    public boolean hasBookingId() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'bookingId' field.
      * @return This builder.
      */
    public Builder clearBookingId() {
      bookingId = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'expiredFlag' field.
      * @return The value.
      */
    public CharSequence getExpiredFlag() {
      return expiredFlag;
    }

    /**
      * Sets the value of the 'expiredFlag' field.
      * @param value The value of 'expiredFlag'.
      * @return This builder.
      */
    public Builder setExpiredFlag(CharSequence value) {
      validate(fields()[4], value);
      this.expiredFlag = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'expiredFlag' field has been set.
      * @return True if the 'expiredFlag' field has been set, false otherwise.
      */
    public boolean hasExpiredFlag() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'expiredFlag' field.
      * @return This builder.
      */
    public Builder clearExpiredFlag() {
      expiredFlag = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'maturityDate' field.
      * @return The value.
      */
    public Integer getMaturityDate() {
      return maturityDate;
    }

    /**
      * Sets the value of the 'maturityDate' field.
      * @param value The value of 'maturityDate'.
      * @return This builder.
      */
    public Builder setMaturityDate(int value) {
      validate(fields()[5], value);
      this.maturityDate = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'maturityDate' field has been set.
      * @return True if the 'maturityDate' field has been set, false otherwise.
      */
    public boolean hasMaturityDate() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'maturityDate' field.
      * @return This builder.
      */
    public Builder clearMaturityDate() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'createdDate' field.
      * @return The value.
      */
    public Integer getCreatedDate() {
      return createdDate;
    }

    /**
      * Sets the value of the 'createdDate' field.
      * @param value The value of 'createdDate'.
      * @return This builder.
      */
    public Builder setCreatedDate(int value) {
      validate(fields()[6], value);
      this.createdDate = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'createdDate' field has been set.
      * @return True if the 'createdDate' field has been set, false otherwise.
      */
    public boolean hasCreatedDate() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'createdDate' field.
      * @return This builder.
      */
    public Builder clearCreatedDate() {
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TradeStore build() {
      try {
        TradeStore record = new TradeStore();
        record.tradeId = fieldSetFlags()[0] ? this.tradeId : (CharSequence) defaultValue(fields()[0]);
        record.counterPartyId = fieldSetFlags()[1] ? this.counterPartyId : (CharSequence) defaultValue(fields()[1]);
        record.version = fieldSetFlags()[2] ? this.version : (Integer) defaultValue(fields()[2]);
        record.bookingId = fieldSetFlags()[3] ? this.bookingId : (CharSequence) defaultValue(fields()[3]);
        record.expiredFlag = fieldSetFlags()[4] ? this.expiredFlag : (CharSequence) defaultValue(fields()[4]);
        record.maturityDate = fieldSetFlags()[5] ? this.maturityDate : (Integer) defaultValue(fields()[5]);
        record.createdDate = fieldSetFlags()[6] ? this.createdDate : (Integer) defaultValue(fields()[6]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TradeStore>
    WRITER$ = (org.apache.avro.io.DatumWriter<TradeStore>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TradeStore>
    READER$ = (org.apache.avro.io.DatumReader<TradeStore>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}