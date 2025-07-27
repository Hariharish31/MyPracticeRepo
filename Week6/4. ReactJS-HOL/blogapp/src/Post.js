import React from 'react';
import Post from './Post'; // Assuming Post.js is in the same directory

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: []
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        const loadedPosts = data.map(item => new Post(item.id, item.title, item.body));
        this.setState({ posts: loadedPosts });
      })
      .catch(error => {
        console.error("Error fetching posts:", error);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  render() {
    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map(post => (
          <div key={post.id}> 
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }

  componentDidCatch(error, info) {
    alert(`An error occurred: ${error.message}`);
    console.error("Caught an error:", error, info);
  }
}

export default Posts;