package enumeratum.values

import BSONValueHandlers._
import reactivemongo.bson._

/**
 * @author Alessandro Lacava (@lambdista)
 * @since 2016-04-23
 */

sealed trait ReactiveMongoBsonValueEnum[ValueType <: AnyVal, EntryType <: ValueEnumEntry[ValueType]] {
  enum: ValueEnum[ValueType, EntryType] =>

  /**
   * Implicit BSON handler for the entries of this enum
   */
  implicit def bsonHandler: BSONHandler[BSONValue, EntryType]
}

/**
 * Enum implementation for Int enum members that contains an implicit ReactiveMongo BSON Handler
 */
trait IntReactiveMongoBsonValueEnum[EntryType <: IntEnumEntry] extends ReactiveMongoBsonValueEnum[Int, EntryType] {
  this: IntEnum[EntryType] =>

  implicit val bsonHandler: BSONHandler[BSONValue, EntryType] = EnumHandler.handler(this)
}

/**
 * Enum implementation for Long enum members that contains an implicit ReactiveMongo BSON Handler
 */
trait LongReactiveMongoBsonValueEnum[EntryType <: LongEnumEntry] extends ReactiveMongoBsonValueEnum[Long, EntryType] {
  this: LongEnum[EntryType] =>

  implicit val bsonHandler: BSONHandler[BSONValue, EntryType] = EnumHandler.handler(this)
}

/**
 * Enum implementation for Short enum members that contains an implicit ReactiveMongo BSON Handler
 */
trait ShortReactiveMongoBsonValueEnum[EntryType <: ShortEnumEntry] extends ReactiveMongoBsonValueEnum[Short, EntryType] {
  this: ShortEnum[EntryType] =>

  implicit val bsonHandler: BSONHandler[BSONValue, EntryType] = EnumHandler.handler(this)
}
