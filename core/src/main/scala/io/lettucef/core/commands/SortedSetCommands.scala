// Code generated. DO NOT EDIT
package io.lettucef.core.commands

import io.lettuce.core.KeyValue
import io.lettuce.core.Limit
import io.lettuce.core.Range
import io.lettuce.core.ScanArgs
import io.lettuce.core.ScanCursor
import io.lettuce.core.ScoredValue
import io.lettuce.core.ScoredValueScanCursor
import io.lettuce.core.StreamScanCursor
import io.lettuce.core.ZAddArgs
import io.lettuce.core.ZAggregateArgs
import io.lettuce.core.ZStoreArgs
import io.lettuce.core.output.ScoredValueStreamingChannel
import cats.syntax.functor._
import io.lettuce.core.api.async._
import io.lettucef.core.util.{JavaFutureUtil => JF}
import scala.jdk.CollectionConverters._


trait SortedSetCommands[F[_], K, V] extends AsyncCallCommands[F, K, V] {

  protected val underlying: RedisSortedSetAsyncCommands[K, V]
  
  def bzpopmin(timeout: Long, keys: K*): F[KeyValue[K, ScoredValue[V]]] =
    JF.toAsync(underlying.bzpopmin(timeout, keys: _*))
  
  def bzpopmin(timeout: Double, keys: K*): F[KeyValue[K, ScoredValue[V]]] =
    JF.toAsync(underlying.bzpopmin(timeout, keys: _*))
  
  def bzpopmax(timeout: Long, keys: K*): F[KeyValue[K, ScoredValue[V]]] =
    JF.toAsync(underlying.bzpopmax(timeout, keys: _*))
  
  def bzpopmax(timeout: Double, keys: K*): F[KeyValue[K, ScoredValue[V]]] =
    JF.toAsync(underlying.bzpopmax(timeout, keys: _*))
  
  def zadd(key: K, score: Double, member: V): F[Long] =
    JF.toAsync(underlying.zadd(key, score, member)).map(Long2long)
  
  def zadd(key: K, scoredValues: ScoredValue[V]*): F[Long] =
    JF.toAsync(underlying.zadd(key, scoredValues: _*)).map(Long2long)
  
  def zadd(key: K, zAddArgs: ZAddArgs, score: Double, member: V): F[Long] =
    JF.toAsync(underlying.zadd(key, zAddArgs, score, member)).map(Long2long)
  
  def zadd(key: K, zAddArgs: ZAddArgs, scoredValues: ScoredValue[V]*): F[Long] =
    JF.toAsync(underlying.zadd(key, zAddArgs, scoredValues: _*)).map(Long2long)
  
  def zaddincr(key: K, score: Double, member: V): F[Double] =
    JF.toAsync(underlying.zaddincr(key, score, member)).map(Double2double)
  
  def zaddincr(key: K, zAddArgs: ZAddArgs, score: Double, member: V): F[Double] =
    JF.toAsync(underlying.zaddincr(key, zAddArgs, score, member)).map(Double2double)
  
  def zcard(key: K): F[Long] =
    JF.toAsync(underlying.zcard(key)).map(Long2long)
  
  def zcount(key: K, range: Range[_ <: Number]): F[Long] =
    JF.toAsync(underlying.zcount(key, range)).map(Long2long)
  
  def zdiff(keys: K*): F[Seq[V]] =
    JF.toAsync(underlying.zdiff(keys: _*)).map(_.asScala.toSeq)
  
  def zdiffstore(destKey: K, srcKeys: K*): F[Long] =
    JF.toAsync(underlying.zdiffstore(destKey, srcKeys: _*)).map(Long2long)
  
  def zdiffWithScores(keys: K*): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zdiffWithScores(keys: _*)).map(_.asScala.toSeq)
  
  def zincrby(key: K, amount: Double, member: V): F[Double] =
    JF.toAsync(underlying.zincrby(key, amount, member)).map(Double2double)
  
  def zinter(keys: K*): F[Seq[V]] =
    JF.toAsync(underlying.zinter(keys: _*)).map(_.asScala.toSeq)
  
  def zinter(aggregateArgs: ZAggregateArgs, keys: K*): F[Seq[V]] =
    JF.toAsync(underlying.zinter(aggregateArgs, keys: _*)).map(_.asScala.toSeq)
  
  def zinterWithScores(aggregateArgs: ZAggregateArgs, keys: K*): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zinterWithScores(aggregateArgs, keys: _*)).map(_.asScala.toSeq)
  
  def zinterWithScores(keys: K*): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zinterWithScores(keys: _*)).map(_.asScala.toSeq)
  
  def zinterstore(destination: K, keys: K*): F[Long] =
    JF.toAsync(underlying.zinterstore(destination, keys: _*)).map(Long2long)
  
  def zinterstore(destination: K, storeArgs: ZStoreArgs, keys: K*): F[Long] =
    JF.toAsync(underlying.zinterstore(destination, storeArgs, keys: _*)).map(Long2long)
  
  def zlexcount(key: K, range: Range[_ <: V]): F[Long] =
    JF.toAsync(underlying.zlexcount(key, range)).map(Long2long)
  
  def zmscore(key: K, members: V*): F[Seq[Double]] =
    JF.toAsync(underlying.zmscore(key, members: _*)).map(_.asScala.toSeq.map(Double2double))
  
  def zpopmin(key: K): F[ScoredValue[V]] =
    JF.toAsync(underlying.zpopmin(key))
  
  def zpopmin(key: K, count: Long): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zpopmin(key, count)).map(_.asScala.toSeq)
  
  def zpopmax(key: K): F[ScoredValue[V]] =
    JF.toAsync(underlying.zpopmax(key))
  
  def zpopmax(key: K, count: Long): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zpopmax(key, count)).map(_.asScala.toSeq)
  
  def zrandmember(key: K): F[V] =
    JF.toAsync(underlying.zrandmember(key))
  
  def zrandmember(key: K, count: Long): F[Seq[V]] =
    JF.toAsync(underlying.zrandmember(key, count)).map(_.asScala.toSeq)
  
  def zrandmemberWithScores(key: K): F[ScoredValue[V]] =
    JF.toAsync(underlying.zrandmemberWithScores(key))
  
  def zrandmemberWithScores(key: K, count: Long): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zrandmemberWithScores(key, count)).map(_.asScala.toSeq)
  
  def zrange(key: K, start: Long, stop: Long): F[Seq[V]] =
    JF.toAsync(underlying.zrange(key, start, stop)).map(_.asScala.toSeq)
  
  def zrangeWithScores(key: K, start: Long, stop: Long): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zrangeWithScores(key, start, stop)).map(_.asScala.toSeq)
  
  def zrangeWithScores(channel: ScoredValueStreamingChannel[V], key: K, start: Long, stop: Long): F[Long] =
    JF.toAsync(underlying.zrangeWithScores(channel, key, start, stop)).map(Long2long)
  
  def zrangebylex(key: K, range: Range[_ <: V]): F[Seq[V]] =
    JF.toAsync(underlying.zrangebylex(key, range)).map(_.asScala.toSeq)
  
  def zrangebylex(key: K, range: Range[_ <: V], limit: Limit): F[Seq[V]] =
    JF.toAsync(underlying.zrangebylex(key, range, limit)).map(_.asScala.toSeq)
  
  def zrangebyscore(key: K, range: Range[_ <: Number]): F[Seq[V]] =
    JF.toAsync(underlying.zrangebyscore(key, range)).map(_.asScala.toSeq)
  
  def zrangebyscore(key: K, range: Range[_ <: Number], limit: Limit): F[Seq[V]] =
    JF.toAsync(underlying.zrangebyscore(key, range, limit)).map(_.asScala.toSeq)
  
  def zrangebyscoreWithScores(key: K, range: Range[_ <: Number]): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zrangebyscoreWithScores(key, range)).map(_.asScala.toSeq)
  
  def zrangebyscoreWithScores(key: K, range: Range[_ <: Number], limit: Limit): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zrangebyscoreWithScores(key, range, limit)).map(_.asScala.toSeq)
  
  def zrangebyscoreWithScores(channel: ScoredValueStreamingChannel[V], key: K, range: Range[_ <: Number]): F[Long] =
    JF.toAsync(underlying.zrangebyscoreWithScores(channel, key, range)).map(Long2long)
  
  def zrangebyscoreWithScores(channel: ScoredValueStreamingChannel[V], key: K, range: Range[_ <: Number], limit: Limit): F[Long] =
    JF.toAsync(underlying.zrangebyscoreWithScores(channel, key, range, limit)).map(Long2long)
  
  def zrangestorebylex(dstKey: K, srcKey: K, range: Range[_ <: V], limit: Limit): F[Long] =
    JF.toAsync(underlying.zrangestorebylex(dstKey, srcKey, range, limit)).map(Long2long)
  
  def zrangestorebyscore(dstKey: K, srcKey: K, range: Range[_ <: Number], limit: Limit): F[Long] =
    JF.toAsync(underlying.zrangestorebyscore(dstKey, srcKey, range, limit)).map(Long2long)
  
  def zrank(key: K, member: V): F[Long] =
    JF.toAsync(underlying.zrank(key, member)).map(Long2long)
  
  def zrem(key: K, members: V*): F[Long] =
    JF.toAsync(underlying.zrem(key, members: _*)).map(Long2long)
  
  def zremrangebylex(key: K, range: Range[_ <: V]): F[Long] =
    JF.toAsync(underlying.zremrangebylex(key, range)).map(Long2long)
  
  def zremrangebyrank(key: K, start: Long, stop: Long): F[Long] =
    JF.toAsync(underlying.zremrangebyrank(key, start, stop)).map(Long2long)
  
  def zremrangebyscore(key: K, range: Range[_ <: Number]): F[Long] =
    JF.toAsync(underlying.zremrangebyscore(key, range)).map(Long2long)
  
  def zrevrange(key: K, start: Long, stop: Long): F[Seq[V]] =
    JF.toAsync(underlying.zrevrange(key, start, stop)).map(_.asScala.toSeq)
  
  def zrevrangeWithScores(key: K, start: Long, stop: Long): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zrevrangeWithScores(key, start, stop)).map(_.asScala.toSeq)
  
  def zrevrangeWithScores(channel: ScoredValueStreamingChannel[V], key: K, start: Long, stop: Long): F[Long] =
    JF.toAsync(underlying.zrevrangeWithScores(channel, key, start, stop)).map(Long2long)
  
  def zrevrangebylex(key: K, range: Range[_ <: V]): F[Seq[V]] =
    JF.toAsync(underlying.zrevrangebylex(key, range)).map(_.asScala.toSeq)
  
  def zrevrangebylex(key: K, range: Range[_ <: V], limit: Limit): F[Seq[V]] =
    JF.toAsync(underlying.zrevrangebylex(key, range, limit)).map(_.asScala.toSeq)
  
  def zrevrangebyscore(key: K, range: Range[_ <: Number]): F[Seq[V]] =
    JF.toAsync(underlying.zrevrangebyscore(key, range)).map(_.asScala.toSeq)
  
  def zrevrangebyscore(key: K, range: Range[_ <: Number], limit: Limit): F[Seq[V]] =
    JF.toAsync(underlying.zrevrangebyscore(key, range, limit)).map(_.asScala.toSeq)
  
  def zrevrangebyscoreWithScores(key: K, range: Range[_ <: Number]): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zrevrangebyscoreWithScores(key, range)).map(_.asScala.toSeq)
  
  def zrevrangebyscoreWithScores(key: K, range: Range[_ <: Number], limit: Limit): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zrevrangebyscoreWithScores(key, range, limit)).map(_.asScala.toSeq)
  
  def zrevrangebyscoreWithScores(channel: ScoredValueStreamingChannel[V], key: K, range: Range[_ <: Number]): F[Long] =
    JF.toAsync(underlying.zrevrangebyscoreWithScores(channel, key, range)).map(Long2long)
  
  def zrevrangebyscoreWithScores(channel: ScoredValueStreamingChannel[V], key: K, range: Range[_ <: Number], limit: Limit): F[Long] =
    JF.toAsync(underlying.zrevrangebyscoreWithScores(channel, key, range, limit)).map(Long2long)
  
  def zrevrangestorebylex(dstKey: K, srcKey: K, range: Range[_ <: V], limit: Limit): F[Long] =
    JF.toAsync(underlying.zrevrangestorebylex(dstKey, srcKey, range, limit)).map(Long2long)
  
  def zrevrangestorebyscore(dstKey: K, srcKey: K, range: Range[_ <: Number], limit: Limit): F[Long] =
    JF.toAsync(underlying.zrevrangestorebyscore(dstKey, srcKey, range, limit)).map(Long2long)
  
  def zrevrank(key: K, member: V): F[Long] =
    JF.toAsync(underlying.zrevrank(key, member)).map(Long2long)
  
  def zscan(key: K): F[ScoredValueScanCursor[V]] =
    JF.toAsync(underlying.zscan(key))
  
  def zscan(key: K, scanArgs: ScanArgs): F[ScoredValueScanCursor[V]] =
    JF.toAsync(underlying.zscan(key, scanArgs))
  
  def zscan(key: K, scanCursor: ScanCursor, scanArgs: ScanArgs): F[ScoredValueScanCursor[V]] =
    JF.toAsync(underlying.zscan(key, scanCursor, scanArgs))
  
  def zscan(key: K, scanCursor: ScanCursor): F[ScoredValueScanCursor[V]] =
    JF.toAsync(underlying.zscan(key, scanCursor))
  
  def zscan(channel: ScoredValueStreamingChannel[V], key: K): F[StreamScanCursor] =
    JF.toAsync(underlying.zscan(channel, key))
  
  def zscan(channel: ScoredValueStreamingChannel[V], key: K, scanArgs: ScanArgs): F[StreamScanCursor] =
    JF.toAsync(underlying.zscan(channel, key, scanArgs))
  
  def zscan(channel: ScoredValueStreamingChannel[V], key: K, scanCursor: ScanCursor, scanArgs: ScanArgs): F[StreamScanCursor] =
    JF.toAsync(underlying.zscan(channel, key, scanCursor, scanArgs))
  
  def zscan(channel: ScoredValueStreamingChannel[V], key: K, scanCursor: ScanCursor): F[StreamScanCursor] =
    JF.toAsync(underlying.zscan(channel, key, scanCursor))
  
  def zscore(key: K, member: V): F[Double] =
    JF.toAsync(underlying.zscore(key, member)).map(Double2double)
  
  def zunion(keys: K*): F[Seq[V]] =
    JF.toAsync(underlying.zunion(keys: _*)).map(_.asScala.toSeq)
  
  def zunion(aggregateArgs: ZAggregateArgs, keys: K*): F[Seq[V]] =
    JF.toAsync(underlying.zunion(aggregateArgs, keys: _*)).map(_.asScala.toSeq)
  
  def zunionWithScores(aggregateArgs: ZAggregateArgs, keys: K*): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zunionWithScores(aggregateArgs, keys: _*)).map(_.asScala.toSeq)
  
  def zunionWithScores(keys: K*): F[Seq[ScoredValue[V]]] =
    JF.toAsync(underlying.zunionWithScores(keys: _*)).map(_.asScala.toSeq)
  
  def zunionstore(destination: K, keys: K*): F[Long] =
    JF.toAsync(underlying.zunionstore(destination, keys: _*)).map(Long2long)
  
  def zunionstore(destination: K, storeArgs: ZStoreArgs, keys: K*): F[Long] =
    JF.toAsync(underlying.zunionstore(destination, storeArgs, keys: _*)).map(Long2long)
  
}

