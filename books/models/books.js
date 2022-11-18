const bookSchema = {
  type: "object",
  properties: {
    author: {
      type: "string",
    },
    title: {
      type: "string",
    },
    total: {
      type: "integer",
    },
    borrowed: {
      type: "integer",
    },
  },
  required: ["author", "title", "total", "borrowed"],
};

module.exports = { bookSchema };