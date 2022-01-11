// Code generated. DO NOT EDIT
package dev.naoh.lettucef.core.sync

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
  
  def auth(password: CharSequence): F[String] =
    JF.toSync(underlying.auth(password))
  
  def auth(username: String, password: CharSequence): F[String] =
    JF.toSync(underlying.auth(username, password))
  
  def clusterBumpepoch(): F[String] =
    JF.toSync(underlying.clusterBumpepoch())
  
  def clusterMeet(ip: String, port: Int): F[String] =
    JF.toSync(underlying.clusterMeet(ip, port))
  
  def clusterForget(nodeId: String): F[String] =
    JF.toSync(underlying.clusterForget(nodeId))
  
  def clusterAddSlots(slots: Int*): F[String] =
    JF.toSync(underlying.clusterAddSlots(slots: _*))
  
  def clusterDelSlots(slots: Int*): F[String] =
    JF.toSync(underlying.clusterDelSlots(slots: _*))
  
  def clusterSetSlotNode(slot: Int, nodeId: String): F[String] =
    JF.toSync(underlying.clusterSetSlotNode(slot, nodeId))
  
  def clusterSetSlotStable(slot: Int): F[String] =
    JF.toSync(underlying.clusterSetSlotStable(slot))
  
  def clusterSetSlotMigrating(slot: Int, nodeId: String): F[String] =
    JF.toSync(underlying.clusterSetSlotMigrating(slot, nodeId))
  
  def clusterSetSlotImporting(slot: Int, nodeId: String): F[String] =
    JF.toSync(underlying.clusterSetSlotImporting(slot, nodeId))
  
  def clusterInfo(): F[String] =
    JF.toSync(underlying.clusterInfo())
  
  def clusterMyId(): F[String] =
    JF.toSync(underlying.clusterMyId())
  
  def clusterNodes(): F[String] =
    JF.toSync(underlying.clusterNodes())
  
  def clusterSlaves(nodeId: String): F[Seq[String]] =
    JF.toSync(underlying.clusterSlaves(nodeId)).map(_.asScala.toSeq)
  
  def clusterGetKeysInSlot(slot: Int, count: Int): F[Seq[K]] =
    JF.toSync(underlying.clusterGetKeysInSlot(slot, count)).map(_.asScala.toSeq)
  
  def clusterCountKeysInSlot(slot: Int): F[Long] =
    JF.toSync(underlying.clusterCountKeysInSlot(slot)).map(Long2long)
  
  def clusterCountFailureReports(nodeId: String): F[Long] =
    JF.toSync(underlying.clusterCountFailureReports(nodeId)).map(Long2long)
  
  def clusterKeyslot(key: K): F[Long] =
    JF.toSync(underlying.clusterKeyslot(key)).map(Long2long)
  
  def clusterSaveconfig(): F[String] =
    JF.toSync(underlying.clusterSaveconfig())
  
  def clusterSetConfigEpoch(configEpoch: Long): F[String] =
    JF.toSync(underlying.clusterSetConfigEpoch(configEpoch))
  
  def clusterSlots(): F[Seq[RedisData[V]]] =
    JF.toSync(underlying.clusterSlots()).map(_.asScala.toSeq.map(RedisData.from[V]))
  
  def asking(): F[String] =
    JF.toSync(underlying.asking())
  
  def clusterReplicate(nodeId: String): F[String] =
    JF.toSync(underlying.clusterReplicate(nodeId))
  
  def clusterFailover(force: Boolean): F[String] =
    JF.toSync(underlying.clusterFailover(force))
  
  def clusterReset(hard: Boolean): F[String] =
    JF.toSync(underlying.clusterReset(hard))
  
  def clusterFlushslots(): F[String] =
    JF.toSync(underlying.clusterFlushslots())
  
}
