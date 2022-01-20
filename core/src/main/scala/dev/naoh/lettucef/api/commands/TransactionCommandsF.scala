// Code generated. DO NOT EDIT
package dev.naoh.lettucef.api.commands

import cats.syntax.functor._
import dev.naoh.lettucef.core.commands.CommandsDeps
import dev.naoh.lettucef.core.util.LettuceValueConverter
import dev.naoh.lettucef.core.util.{JavaFutureUtil => JF}
import io.lettuce.core.api.async._
import scala.jdk.CollectionConverters._


trait TransactionCommandsF[F[_], K, V] {

  def discard(): F[String]
  
  def exec(): F[Boolean]
  
  def multi(): F[String]
  
  def watch(keys: K*): F[String]
  
  def unwatch(): F[String]
  
}
