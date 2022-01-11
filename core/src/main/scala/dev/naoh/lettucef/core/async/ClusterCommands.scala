// Code generated. DO NOT EDIT
package dev.naoh.lettucef.core.async

import cats.syntax.functor._
import dev.naoh.lettucef.core.commands.CommandsDeps
import dev.naoh.lettucef.core.models._
import dev.naoh.lettucef.core.util.LettuceValueConverter
import dev.naoh.lettucef.core.util.{JavaFutureUtil => JF}
import io.lettuce.core.api.async._
import io.lettuce.core.cluster.api.async.RedisClusterAsyncCommands
import scala.jdk.CollectionConverters._


trait ClusterCommands[F[_], K, V] extends CommandsDeps[F, K, V] {

  protected val underlying: RedisClusterAsyncCommands[K, V]
  
  def auth(password: CharSequence): F[F[String]] =
    JF.toAsync(underlying.auth(password))
  
  def auth(username: String, password: CharSequence): F[F[String]] =
    JF.toAsync(underlying.auth(username, password))
  
  def clusterBumpepoch(): F[F[String]] =
    JF.toAsync(underlying.clusterBumpepoch())
  
  def clusterMeet(ip: String, port: Int): F[F[String]] =
    JF.toAsync(underlying.clusterMeet(ip, port))
  
  def clusterForget(nodeId: String): F[F[String]] =
    JF.toAsync(underlying.clusterForget(nodeId))
  
  def clusterAddSlots(slots: Int*): F[F[String]] =
    JF.toAsync(underlying.clusterAddSlots(slots: _*))
  
  def clusterDelSlots(slots: Int*): F[F[String]] =
    JF.toAsync(underlying.clusterDelSlots(slots: _*))
  
  def clusterSetSlotNode(slot: Int, nodeId: String): F[F[String]] =
    JF.toAsync(underlying.clusterSetSlotNode(slot, nodeId))
  
  def clusterSetSlotStable(slot: Int): F[F[String]] =
    JF.toAsync(underlying.clusterSetSlotStable(slot))
  
  def clusterSetSlotMigrating(slot: Int, nodeId: String): F[F[String]] =
    JF.toAsync(underlying.clusterSetSlotMigrating(slot, nodeId))
  
  def clusterSetSlotImporting(slot: Int, nodeId: String): F[F[String]] =
    JF.toAsync(underlying.clusterSetSlotImporting(slot, nodeId))
  
  def clusterInfo(): F[F[String]] =
    JF.toAsync(underlying.clusterInfo())
  
  def clusterMyId(): F[F[String]] =
    JF.toAsync(underlying.clusterMyId())
  
  def clusterNodes(): F[F[String]] =
    JF.toAsync(underlying.clusterNodes())
  
  def clusterSlaves(nodeId: String): F[F[Seq[String]]] =
    JF.toAsync(underlying.clusterSlaves(nodeId)).map(_.map(_.asScala.toSeq))
  
  def clusterGetKeysInSlot(slot: Int, count: Int): F[F[Seq[K]]] =
    JF.toAsync(underlying.clusterGetKeysInSlot(slot, count)).map(_.map(_.asScala.toSeq))
  
  def clusterCountKeysInSlot(slot: Int): F[F[Long]] =
    JF.toAsync(underlying.clusterCountKeysInSlot(slot)).map(_.map(Long2long))
  
  def clusterCountFailureReports(nodeId: String): F[F[Long]] =
    JF.toAsync(underlying.clusterCountFailureReports(nodeId)).map(_.map(Long2long))
  
  def clusterKeyslot(key: K): F[F[Long]] =
    JF.toAsync(underlying.clusterKeyslot(key)).map(_.map(Long2long))
  
  def clusterSaveconfig(): F[F[String]] =
    JF.toAsync(underlying.clusterSaveconfig())
  
  def clusterSetConfigEpoch(configEpoch: Long): F[F[String]] =
    JF.toAsync(underlying.clusterSetConfigEpoch(configEpoch))
  
  def clusterSlots(): F[F[Seq[RedisData[V]]]] =
    JF.toAsync(underlying.clusterSlots()).map(_.map(_.asScala.toSeq.map(RedisData.from[V])))
  
  def asking(): F[F[String]] =
    JF.toAsync(underlying.asking())
  
  def clusterReplicate(nodeId: String): F[F[String]] =
    JF.toAsync(underlying.clusterReplicate(nodeId))
  
  def clusterFailover(force: Boolean): F[F[String]] =
    JF.toAsync(underlying.clusterFailover(force))
  
  def clusterReset(hard: Boolean): F[F[String]] =
    JF.toAsync(underlying.clusterReset(hard))
  
  def clusterFlushslots(): F[F[String]] =
    JF.toAsync(underlying.clusterFlushslots())
  
}
