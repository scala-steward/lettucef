// Code generated. DO NOT EDIT
package dev.naoh.lettucef.api.commands



trait HLLCommandsF[F[_], K, V] {

  def pfadd(key: K, values: V*): F[Long]
  
  def pfmerge(destkey: K, sourcekeys: K*): F[String]
  
  def pfcount(keys: K*): F[Long]
  
}
