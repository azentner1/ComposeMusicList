package com.andrej.composemusiclist.base.mapper

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity): DomainModel

    fun mapToEntity(model: DomainModel): Entity
}