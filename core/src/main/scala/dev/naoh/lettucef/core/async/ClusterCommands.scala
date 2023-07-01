// Code generated by codegen/run; DO NOT EDIT
package dev.naoh.lettucef.core.async

import dev.naoh.lettucef.api.commands.ClusterCommandsF
import dev.naoh.lettucef.api.Commands
import cats.syntax.functor._
import dev.naoh.lettucef.api.models._
import dev.naoh.lettucef.core.commands.CommandsDeps
import dev.naoh.lettucef.core.util.{JavaFutureUtil => JF}
import io.lettuce.core.api.async._
import io.lettuce.core.cluster.api.async.RedisClusterAsyncCommands
import io.lettuce.core.protocol.CommandKeyword
import io.lettuce.core.protocol.CommandType
import scala.jdk.CollectionConverters._


trait ClusterCommands[F[_], K, V] extends CommandsDeps[F, K, V] with ClusterCommandsF[Commands.Compose[F, F]#R, K, V] {

  protected val underlying: RedisClusterAsyncCommands[K, V] with BaseRedisAsyncCommands[K, V]
  
  def asking(): F[F[String]] =
    JF.toAsync(underlying.asking())
  
  def auth(password: CharSequence): F[F[String]] =
    JF.toAsync(underlying.auth(password))
  
  def auth(username: String, password: CharSequence): F[F[String]] =
    JF.toAsync(underlying.auth(username, password))
  
  def clusterAddSlots(slots: Int*): F[F[String]] =
    JF.toAsync(underlying.clusterAddSlots(slots: _*))
  
  def clusterBumpepoch(): F[F[String]] =
    JF.toAsync(underlying.clusterBumpepoch())
  
  def clusterCountFailureReports(nodeId: String): F[F[Long]] =
    JF.toAsync(underlying.clusterCountFailureReports(nodeId)).map(_.map(Long2long))
  
  def clusterCountKeysInSlot(slot: Int): F[F[Long]] =
    JF.toAsync(underlying.clusterCountKeysInSlot(slot)).map(_.map(Long2long))
  
  def clusterAddSlotsRange(ranges: RedisRange[Integer]*): F[F[String]] =
    JF.toAsync(underlying.clusterAddSlotsRange(ranges.map(_.toJavaAuto): _*))
  
  def clusterDelSlots(slots: Int*): F[F[String]] =
    JF.toAsync(underlying.clusterDelSlots(slots: _*))
  
  def clusterDelSlotsRange(ranges: RedisRange[Integer]*): F[F[String]] =
    JF.toAsync(underlying.clusterDelSlotsRange(ranges.map(_.toJavaAuto): _*))
  
  def clusterFailover(force: Boolean): F[F[String]] =
    JF.toAsync(underlying.clusterFailover(force))
  
  def clusterFailover(force: Boolean, takeOver: Boolean): F[F[String]] =
    JF.toAsync(underlying.clusterFailover(force, takeOver))
  
  def clusterFlushslots(): F[F[String]] =
    JF.toAsync(underlying.clusterFlushslots())
  
  def clusterForget(nodeId: String): F[F[String]] =
    JF.toAsync(underlying.clusterForget(nodeId))
  
  def clusterGetKeysInSlot(slot: Int, count: Int): F[F[Seq[K]]] =
    JF.toAsync(underlying.clusterGetKeysInSlot(slot, count)).map(_.map(_.asScala.toSeq))
  
  def clusterInfo(): F[F[String]] =
    JF.toAsync(underlying.clusterInfo())
  
  def clusterKeyslot(key: K): F[F[Long]] =
    JF.toAsync(underlying.clusterKeyslot(key)).map(_.map(Long2long))
  
  def clusterMeet(ip: String, port: Int): F[F[String]] =
    JF.toAsync(underlying.clusterMeet(ip, port))
  
  def clusterMyId(): F[F[String]] =
    JF.toAsync(underlying.clusterMyId())
  
  def clusterNodes(): F[F[String]] =
    JF.toAsync(underlying.clusterNodes())
  
  def clusterReplicate(nodeId: String): F[F[String]] =
    JF.toAsync(underlying.clusterReplicate(nodeId))
  
  def clusterReplicas(nodeId: String): F[F[Seq[String]]] =
    JF.toAsync(underlying.clusterReplicas(nodeId)).map(_.map(_.asScala.toSeq))
  
  def clusterReset(hard: Boolean): F[F[String]] =
    JF.toAsync(underlying.clusterReset(hard))
  
  def clusterSaveconfig(): F[F[String]] =
    JF.toAsync(underlying.clusterSaveconfig())
  
  def clusterSetConfigEpoch(configEpoch: Long): F[F[String]] =
    JF.toAsync(underlying.clusterSetConfigEpoch(configEpoch))
  
  def clusterSetSlotImporting(slot: Int, nodeId: String): F[F[String]] =
    JF.toAsync(underlying.clusterSetSlotImporting(slot, nodeId))
  
  def clusterSetSlotMigrating(slot: Int, nodeId: String): F[F[String]] =
    JF.toAsync(underlying.clusterSetSlotMigrating(slot, nodeId))
  
  def clusterSetSlotNode(slot: Int, nodeId: String): F[F[String]] =
    JF.toAsync(underlying.clusterSetSlotNode(slot, nodeId))
  
  def clusterSetSlotStable(slot: Int): F[F[String]] =
    JF.toAsync(underlying.clusterSetSlotStable(slot))
  
  def clusterShards(): F[F[List[RedisData[V]]]] =
    JF.toAsync(underlying.dispatch(CommandType.CLUSTER, dispatchHelper.createRedisDataOutput(), dispatchHelper.createArgs().add(CommandKeyword.SLOTS))).map(_.map(_.asList))
  
  def clusterSlots(): F[F[List[RedisData[V]]]] =
    JF.toAsync(underlying.dispatch(CommandType.CLUSTER, dispatchHelper.createRedisDataOutput(), dispatchHelper.createArgs().add(CommandKeyword.SLOTS))).map(_.map(_.asList))
  
}
