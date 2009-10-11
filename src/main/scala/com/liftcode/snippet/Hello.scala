package com.liftcode.snippet

/**
 * Created by IntelliJ IDEA.
 * User: dpp
 * Date: Jun 23, 2009
 * Time: 8:47:29 PM
 * To change this template use File | Settings | File Templates.
 */

import scala.xml.NodeSeq
import net.liftweb.util._
import net.liftweb.mapper._

import model._

class Home {
  def render(in: NodeSeq): NodeSeq = User.currentUser match {
    case Full(user) =>  <p>Thanks again for logging in.</p>

    case _ => {
        val dogs = Dog.findAll(By(Dog.name,"fido"),OrderBy(Dog.name,Ascending),PreCache(Dog.owner))
        <ul>{dogs.flatMap(d => <li>{d.name.is}</li>)}</ul>
    }
  }

}