// Code generated. DO NOT EDIT
package dev.naoh.lettucef.core.async

import dev.naoh.lettucef.api.commands.AclCommandsF
import dev.naoh.lettucef.api.Commands
import cats.syntax.functor._
import dev.naoh.lettucef.api.models._
import dev.naoh.lettucef.core.commands.CommandsDeps
import dev.naoh.lettucef.core.util.{JavaFutureUtil => JF}
import io.lettuce.core.AclCategory
import io.lettuce.core.AclSetuserArgs
import io.lettuce.core.api.async._
import io.lettuce.core.protocol.CommandKeyword
import io.lettuce.core.protocol.CommandType
import scala.jdk.CollectionConverters._


trait AclCommands[F[_], K, V] extends CommandsDeps[F, K, V] with AclCommandsF[Commands.Compose[F, F]#R, K, V] {

  protected val underlying: RedisAclAsyncCommands[K, V] with BaseRedisAsyncCommands[K, V]
  
  def aclCat(): F[F[Set[AclCategory]]] =
    JF.toAsync(underlying.aclCat()).map(_.map(_.asScala.toSet))
  
  def aclCat(category: AclCategory): F[F[Set[CommandType]]] =
    JF.toAsync(underlying.aclCat(category)).map(_.map(_.asScala.toSet))
  
  def aclDeluser(usernames: String*): F[F[Long]] =
    JF.toAsync(underlying.aclDeluser(usernames: _*)).map(_.map(Long2long))
  
  def aclGenpass(): F[F[String]] =
    JF.toAsync(underlying.aclGenpass())
  
  def aclGenpass(bits: Int): F[F[String]] =
    JF.toAsync(underlying.aclGenpass(bits))
  
  def aclGetuser(username: String): F[F[List[RedisData[V]]]] =
    JF.toAsync(underlying.dispatch(CommandType.ACL, dispatchHelper.createRedisDataOutput(), dispatchHelper.createArgs().add(CommandKeyword.GETUSER).add(username))).map(_.map(_.asList))
  
  def aclList(): F[F[Seq[String]]] =
    JF.toAsync(underlying.aclList()).map(_.map(_.asScala.toSeq))
  
  def aclLoad(): F[F[String]] =
    JF.toAsync(underlying.aclLoad())
  
  def aclLog(): F[F[List[RedisData[V]]]] =
    JF.toAsync(underlying.dispatch(CommandType.ACL, dispatchHelper.createRedisDataOutput(), dispatchHelper.createArgs().add(CommandKeyword.LOG))).map(_.map(_.asList))
  
  def aclLog(count: Int): F[F[List[RedisData[V]]]] =
    JF.toAsync(underlying.dispatch(CommandType.ACL, dispatchHelper.createRedisDataOutput(), dispatchHelper.createArgs().add(CommandKeyword.LOG).add(count))).map(_.map(_.asList))
  
  def aclLogReset(): F[F[String]] =
    JF.toAsync(underlying.aclLogReset())
  
  def aclSave(): F[F[String]] =
    JF.toAsync(underlying.aclSave())
  
  def aclSetuser(username: String, setuserArgs: AclSetuserArgs): F[F[String]] =
    JF.toAsync(underlying.aclSetuser(username, setuserArgs))
  
  def aclUsers(): F[F[Seq[String]]] =
    JF.toAsync(underlying.aclUsers()).map(_.map(_.asScala.toSeq))
  
  def aclWhoami(): F[F[String]] =
    JF.toAsync(underlying.aclWhoami())
  
}
