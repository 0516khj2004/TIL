import _ from 'lodash';
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { fetchPosts } from '../actions/index';

import { Link } from 'react-router-dom';
import { bindActionCreators } from 'redux';

class PostsIndex extends Component {
  // define a lifecycle function for retrieve data  
  componentDidMount(){
    this.props.fetchPosts();
  }
  renderPosts() {
    // this.props.posts.blogs.map(  v=>
    //   console.log(v)
    // )
    console.log(this.props.posts)
    return _.map(this.props.posts, post => { 
      return ( 
        <li className='list-group-item' key={post.id}>
          <Link to={`/blogs/${post.id}`}>{post.title}</Link>
        </li>
      ) 
    });
  }
  render() {
    return (
      <div>
        <div className="text-xs-right">
          <Link className='btn btn-primary' to="/blogs/new"> Add a Post </Link>
        </div>
        <h3>Posts</h3>
        <ul className='list-group'>
          {this.renderPosts()}
        </ul>
      </div>
    );
  }
}

function mapStateToProps(state){
  //posts -> reducer index.js 밑
  return { posts : state.posts}
}

// function mapDispatchToProps(dispatch){
//   return bindActionCreators( {fetchPosts}, dispatch)
// }

//{name :name} == {name}
export default connect(mapStateToProps,{fetchPosts})(PostsIndex);

